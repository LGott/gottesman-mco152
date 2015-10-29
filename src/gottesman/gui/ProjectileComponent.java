package gottesman.gui;

import java.awt.Graphics;

import javax.swing.JComponent;

import gottesman.projectile.Projectile;

public class ProjectileComponent extends JComponent {

	Projectile projectile;

	public ProjectileComponent() {

		// Instantiate a new instance of the projectile Class

		projectile = new Projectile(30.0, 21.0, 0.0);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		// Start with the initial time(0.0) and increment
		for (double time = projectile.getTime(); time < 20.0; time += .25) {

			// Get the value for x1 and y1
			int x1 = (int) projectile.getX();
			int y1 = (int) projectile.getY();

			// reset the time
			projectile.setTime(time += .25);

			// Get the new value of x and y
			int x2 = (int) projectile.getX();
			int y2 = (int) projectile.getY();

			// draw a line segment between the points
			g.drawLine(x1, getHeight() - y1, x2, getHeight() - y2);

		}
	}

}