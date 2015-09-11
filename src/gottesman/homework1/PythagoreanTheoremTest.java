package gottesman.homework1;

import org.junit.Assert;
import org.junit.Test;

public class PythagoreanTheoremTest {

	@Test
	public void testAB() {

		PythagoreanTheorem p = new PythagoreanTheorem();

		p.setAB(3, 4); // Set A and B to calculate C

		Assert.assertEquals(5, p.getC(), .01);
	}

	@Test
	public void testAC() {

		PythagoreanTheorem p = new PythagoreanTheorem();

		p.setAC(6, 10); // Set A and C to calculate B

		Assert.assertEquals(8, p.getB(), .01);
	}

	@Test
	public void testBC() {

		PythagoreanTheorem p = new PythagoreanTheorem();

		p.setBC(5, 13); // Set B and C to calculate A

		Assert.assertEquals(12, p.getA(), .01);

	}
}
