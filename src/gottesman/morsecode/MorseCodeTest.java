package gottesman.morsecode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testEncode() {

		MorseCode code = new MorseCode();

		Assert.assertEquals(".--- .- ...- .-   .-. --- -..-   .--- .- ...- .- ", code.encode("java rox java"));
	}

	@Test
	public void testDecode() {

		MorseCode code = new MorseCode();

		Assert.assertEquals("abc", code.decode(".- -... -.-."));
	}

}
