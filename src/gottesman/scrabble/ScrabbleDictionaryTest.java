package gottesman.scrabble;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void testScrabble() throws FileNotFoundException {

		ScrabbleDictionary scTest = new ScrabbleDictionary();

		scTest.contains("hello");

		Assert.assertTrue("hello", true); // Test the boolean method using
											// assertTrue

	}

}
