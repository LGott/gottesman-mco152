package gottesman.connect4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton restart;
	private JButton exit;

	public GameJFrame() {

		setTitle("Connect Four"); // Set the title
		setSize(1200, 1450); // Set size
		setBackground(Color.GREEN);
		setResizable(false); // Make sure that no one can resize the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Set the GUI to appear in the center of the screen

		BorderLayout layout = new BorderLayout(); // Create a new BorderLayout
		Container container = getContentPane(); // Create a container
		container.setLayout(layout); // Add the layout to the container

		// add a new ConnectFour object to the container, passing 7 and 6 as arguments for the columns and rows
		container.add(new ConnectFour(7, 6), BorderLayout.CENTER);

		restart = new JButton("Restart"); // Add a restart button on top
		container.add(restart, BorderLayout.NORTH);

		restart.addActionListener(new ActionListener() {

			// When the restart button is clicked, dispose of the game, but then instantiate a new game right away
			@Override
			public void actionPerformed(ActionEvent event) {

				dispose();
				new GameJFrame().setVisible(true);
			}
		});

		exit = new JButton("Exit"); // Add an exit button on bottom
		container.add(exit, BorderLayout.SOUTH);

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				// Dispose of the game when the button is clicked
				dispose();
			}
		});

	}
}