package gottesman.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.ImageIcon;

import com.google.gson.Gson;

public class ImageConnection extends Thread {

	String url;
	ImageIcon icon;

	public ImageConnection(String url, ImageIcon icon) {

		this.url = url;
		this.icon = icon;
	}

	public NYPL getImageConnection() throws IOException {

		URL theURL = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) theURL.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();

		return gson.fromJson(br, NYPL.class);

	}

	@Override
	public void run() {
		try {

			NYPL nypl = getImageConnection();

			NyplAPI api = nypl.getNYPLApi();
			Response response = api.getResponse();
			Capture[] captures = response.getCaptures();
			ImageLinks images = captures[0].getImageLinks();
			ImageLink[] imageArray = images.getImageLinks();

			// String str = imageArray[3];

			// URL url = new URL(captures[3]);
			// icon = new ImageIcon(captures[3]);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}