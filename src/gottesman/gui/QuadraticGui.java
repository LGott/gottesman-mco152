package gottesman.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class QuadraticGui extends JFrame {

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

	public QuadraticGui() throws InvalidDataException {

		// Create the Window
		setTitle("Quadratic GUI");
		setSize(700, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the Layout
		final Container container = getContentPane();

		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		label1 = new JLabel("Enter Value for a: ");
		add(label1);

		a = new JTextField();
		add(a);

		label2 = new JLabel("Enter value for b:");
		add(label2);

		b = new JTextField();
		add(b);

		label3 = new JLabel("Enter value for c:");
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

				String valA = a.getText();
				double a = Double.parseDouble(valA);
				String valB = b.getText();
				double b = Double.parseDouble(valB);
				String valC = c.getText();
				double c = Double.parseDouble(valC);

				if ((a == 0) || (b == 0) || (c == 0)) {
					try {
						throw new InvalidDataException();
					} catch (InvalidDataException e) {
						{
							label6.setText("Invalid Amount Entered.");
						}
						e.printStackTrace();
					}

				}
				// Calculate Negative and Positive X
				double posX = (-b + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);

				double negX = (-b - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);

				label4.setText("Positive x = " + posX);
				label5.setText("Negative x = " + negX);

			}
		});
	}
}
