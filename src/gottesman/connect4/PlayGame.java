package gottesman.connect4;

import javax.swing.JOptionPane;

public class PlayGame {

	public static void main(String[] args) {

		new GameJFrame().setVisible(true);

		JOptionPane.showMessageDialog(null, "Game Rules:\n Click on the column that you wish to place "
				+ "your piece in.\n Four in a row wins!");

	}

}
