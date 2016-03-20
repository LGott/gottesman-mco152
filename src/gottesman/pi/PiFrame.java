package gottesman.pi;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PiFrame extends JFrame {

	public PiFrame() {

		setTitle("");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel();

		Container contentPane = getContentPane();
		contentPane.add(label);

		CalculatePi calc = new CalculatePi();
		double pi = calc.calculate(100);
		label.setText(String.valueOf(pi));

	}

	public static void main(String args[]) {

		new PiFrame().setVisible(true);
	}
}
