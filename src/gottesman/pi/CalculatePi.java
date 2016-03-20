package gottesman.pi;

public class CalculatePi {
	int iterations;

	public double calculate(int iterations) {

		this.iterations = iterations;
		double pi = 0;

		double numerator = 4;
		double denominator = 1;
		boolean positive = true;

		for (int i = 0; i < iterations; i++) {

			if (positive) {
				pi += numerator / denominator;

			} else {
				pi -= numerator / denominator;
			}
			denominator += 2;
			positive = !positive;

		}
		return pi;

	}

	public static void main(String[] args) {

		CalculatePi calc = new CalculatePi();
		System.out.println(calc.calculate(500000));
	}
}