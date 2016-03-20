package gottesman.weather;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherGUI extends JFrame {

	private JLabel degrees;
	private JLabel des;
	private String description;
	private Image image;
	private ImageIcon imageIcon;
	private JLabel command;
	private JTextField zipcode;
	private JButton button;
	private JLabel imageLabel;
	private String temp;

	private static final long serialVersionUID = 1L;

	public WeatherGUI() {

		setTitle("Weather");
		setSize(800, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new FlowLayout(FlowLayout.CENTER));

		command = new JLabel("Enter zipcode of location you would like to search: ");
		zipcode = new JTextField();
		Dimension dim = new Dimension(400, 150);
		zipcode.setMaximumSize(dim);

		button = new JButton("Search");

		degrees = new JLabel();
		des = new JLabel();
		imageLabel = new JLabel();
		imageIcon = new ImageIcon();

		add(command);
		add(zipcode, FlowLayout.CENTER);
		add(button);
		add(degrees);
		add(des);
		add(imageLabel);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				// WeatherInformationThread weather = null;

				try {

					WeatherInformationThread weatherThread = new WeatherInformationThread(zipcode.getText());

					CurrentWeather cw = weatherThread.getWeather();

					Weather[] w = cw.getWeather();
					Main main = cw.getMain();

					description = w[0].getDescription();
					temp = main.getTemp();

					des.setText(description);
					degrees.setText(temp);

					image = weatherThread.imageConnection();
					imageIcon.setImage(image);
					imageLabel.setIcon(imageIcon);

				} catch (IOException e) {
					JLabel error = new JLabel("Oh man!! Internet Connection Problems!");
					add(error);
				}

			}
		});
	}

	public static void main(String args[]) {

		new WeatherGUI().setVisible(true);
	}
}
