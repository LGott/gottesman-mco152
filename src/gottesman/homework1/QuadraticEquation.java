package gottesman.homework1;

public class QuadraticEquation {

	private double a;
	private double b;
	private double c;

	public QuadraticEquation(double a, double b, double c) {

		this.a = a;
		this.b = b;
		this.c = c;

	}
         
	public double getPositiveX() {

		return (-b + Math.sqrt((b * b) - (4 * a * c))) / (2 * a) ;  //Return the pos value of the equation
	}

	public double getNegativeX() {

		return (-b - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);   //Return the neg value of the equation
	}

}
