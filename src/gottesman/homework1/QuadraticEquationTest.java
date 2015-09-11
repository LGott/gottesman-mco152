package gottesman.homework1;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {

	@Test
	public void testGetPositiveX() {

		QuadraticEquation q = new QuadraticEquation(1, -3, -10);  

		Assert.assertEquals(5, q.getPositiveX(), 0.01);   //The above values should result in a +5
	}

	@Test
	public void testGetNegativeX() {

		QuadraticEquation q = new QuadraticEquation(1, -3, -10);

		Assert.assertEquals(-2, q.getNegativeX(), 0.01);   //The above values should result in a -2
	}

}
