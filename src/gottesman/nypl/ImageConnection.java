package gottesman.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.google.gson.Gson;

public class ImageConnection extends Thread {
	private URL imgURL;
	private SearchList images;
	private JLabel icon;
	private JLabel num;
	private JButton previous;
	private JButton next;
	private int currentImageIndex;
	private int numResults;
	private Capture[] capture;
	private ImageConnection imgConn;
	private NYPLGui nyplFrame;

	public ImageConnection(URL url, JLabel icon, JLabel num, JButton previous, JButton next, NYPLGui nyplFrame) {
		this.imgURL = url;
		this.icon = icon;
		this.num = num;
		this.previous = previous;
		this.next = next;
		this.currentImageIndex = 0;
		this.imgConn = this;
		this.nyplFrame = nyplFrame;

	}

	@Override
	public void run() {

		HttpURLConnection connection;
		try {
			connection = (HttpURLConnection) this.imgURL.openConnection();
			connection.setRequestProperty("Authorization", "Token token=\"h8ursz9f4t1lekeh\"");
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			Gson gson = new Gson();
			images = gson.fromJson(reader, SearchList.class);
			setImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setImage() {
		Response api = images.getNyplAPI().getResponse();
		this.numResults = api.getNumResults();
		capture = api.getCapture();
		if (numResults > 0) {
			resetImage();
		}
		this.nyplFrame.setPicThread(imgConn);
	}

	public void previousImage() {
		// TODO Auto-generated method stub
		if (this.currentImageIndex > 0) {
			currentImageIndex--;
			resetImage();
		}
	}

	public void nextImage() {
		if (this.currentImageIndex < (this.numResults - 1)) {
			this.currentImageIndex++;
			resetImage();
		}
	}

	private void resetImage() {
		this.previous.setEnabled(true);
		this.next.setEnabled(true);
		this.num.setText(this.currentImageIndex + 1 + "/" + numResults);
		URL[] imageURL = capture[this.currentImageIndex].getImageLinks().getImageLink();
		ImgDisplay thread = new ImgDisplay(imageURL[3], icon);
		thread.start();
		if (this.currentImageIndex == 0) {
			this.previous.setEnabled(false);
		}
		if (this.currentImageIndex == (this.numResults - 1)) {
			this.next.setEnabled(false);
		}
	}

}