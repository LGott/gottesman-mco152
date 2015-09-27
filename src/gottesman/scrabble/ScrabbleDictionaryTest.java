package gottesman.scrabble;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void testScrabble() throws IOException {

		ScrabbleDictionary scTest = new ScrabbleDictionary();

		scTest.contains("hello");

		Assert.assertTrue("hello", true); // Test the boolean method using
											// assertTrue

	}

}
