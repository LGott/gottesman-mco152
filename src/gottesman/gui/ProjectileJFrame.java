package gottesman.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class ProjectileJFrame extends JFrame {

	public ProjectileJFrame() {

		setTitle("Projectile Graph");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the Layout
		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);

		container.add(new ProjectileComponent(), BorderLayout.CENTER);

	}

	public static void main(String args[]) {

		new ProjectileJFrame().setVisible(true);

	}

}
