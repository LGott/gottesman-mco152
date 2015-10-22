package gottesman.gui;

import javax.swing.JFrame;

public class DisplayGUI {

	public static void main(String args[]) {

		JFrame frame = null;
		try {
			frame = new QuadraticGui();

		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		frame.setVisible(true);

	}
}
