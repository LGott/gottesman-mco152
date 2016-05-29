package gottesman.nypl;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImgDisplay extends Thread {
	private URL url;
	private JLabel icon;

	public ImgDisplay(URL url, JLabel icon) {
		this.url = url;
		this.icon = icon;
	}

	@Override
	public void run() {
		ImageIcon temp = new ImageIcon(url);
		this.icon.setIcon(temp);

	}

}