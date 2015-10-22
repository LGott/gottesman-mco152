package gottesman.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import gottesman.homework1.InvalidDataException;

public class ProjectileGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;
	private final JTextField a;
	private final JTextField b;
	private final JTextField c;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private final JButton button;

	public ProjectileGUI() throws InvalidDataException {

		// Create the Window
		setTitle("Projectile GUI");
		setSize(700, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the Layout
		final Container container = getContentPane();

		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		label1 = new JLabel("Enter Velocity");
		add(label1);

		a = new JTextField();
		add(a);

		label2 = new JLabel("Enter angle");
		add(label2);

		b = new JTextField();
		add(b);

		label3 = new JLabel("Enter Time");
		add(label3);

		c = new JTextField();
		add(c);

		button = new JButton("Submit and Calculate Answer");
		add(button);

		label4 = new JLabel();
		add(label4);

		label5 = new JLabel();
		add(label5);

		label6 = new JLabel();
		add(label6);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub

				String velocity = a.getText();
				double vel = Double.parseDouble(velocity);
				String angle = b.getText();
				double ang = Double.parseDouble(angle);
				String location = c.getText();
				double loc = Double.parseDouble(location);

				if ((vel <= 0) || (ang <= 0) || (loc <= 0)) {
					try {
						throw new InvalidDataException();
					} catch (InvalidDataException e) {
						{
							label6.setText("Invalid Amount Entered.");
						}
						e.printStackTrace();
					}

				}

				double radians = Math.toRadians(ang);
				double x = Math.sin(radians) * vel * loc; // switch to
															// "time"
				double y = (Math.cos(radians) * vel * loc) - (.5 * 9.8 * loc * loc);

				label4.setText("x = " + x);
				label5.setText("y = " + y);

			}
		});
	}
}
