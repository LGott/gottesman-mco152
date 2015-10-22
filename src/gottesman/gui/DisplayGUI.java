package gottesman.gui;

import javax.swing.JFrame;

import gottesman.homework1.InvalidDataException;

public class DisplayGUI {

	public static void main(String args[]) {

		JFrame frame = null;
		try {
			frame = new ProjectileGUI();
		} catch (InvalidDataException e) {
			e.printStackTrace();
		}

		frame.setVisible(true);

	}
}
