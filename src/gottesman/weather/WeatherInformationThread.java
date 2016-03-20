package gottesman.weather;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import com.google.gson.Gson;

public class WeatherInformationThread extends Thread {

	private String zip;
	final Gson gson = new Gson();
	CurrentWeather cw;
	BufferedReader reader;

	public WeatherInformationThread(String zip) throws IOException {

		this.zip = zip;

	}

	@Override
	public void run() {

		StringBuilder urlBuilder = new StringBuilder();

		urlBuilder.append("http://api.openweathermap.org/data/2.5/weather?zip=");
		urlBuilder.append(this.zip);
		urlBuilder.append(",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");

		URL completeURL;
		try {
			completeURL = new URL(urlBuilder.toString());

			HttpURLConnection connection = (HttpURLConnection) completeURL.openConnection();

			java.io.InputStream read = connection.getInputStream();

			reader = new BufferedReader(new InputStreamReader(read));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public CurrentWeather getWeather() {

		cw = gson.fromJson(reader, CurrentWeather.class);

		return cw;
	}

	public Image imageConnection() throws IOException {

		Weather[] w = cw.getWeather();
		String icon = w[0].getIcon();

		StringBuilder builder = new StringBuilder();
		builder.append("http://openweathermap.org/img/w/");
		builder.append(icon);
		builder.append(".png");

		URL imageURL = new URL(builder.toString());

		Image image = ImageIO.read(imageURL);

		return image;

	}

}
