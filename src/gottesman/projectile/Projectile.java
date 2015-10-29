package gottesman.projectile;

public class Projectile {

	double angle;
	double velocity;
	double time;
	double radians;
	double x;
	double y;

	public Projectile(double angle, double velocity, double time) {

		this.angle = angle;
		this.velocity = velocity;
		this.time = time;
		this.radians = Math.toRadians(angle);

	}

	public double getX() {

		this.x = Math.sin(this.radians) * this.velocity * this.time;
		return this.x;
	}

	public double getY() {

		this.y = (Math.cos(this.radians) * this.velocity * this.time) - (.5 * 9.8 * this.time * this.time);
		return this.y;
	}

	public void setTime(double time) {

		this.time = time;

	}

	public double getTime() {
		return this.time;
	}
}
