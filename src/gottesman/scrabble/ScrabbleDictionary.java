package gottesman.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleDictionary {

	String word;
	ArrayList<String> dictionaryWords;

	public ScrabbleDictionary() throws FileNotFoundException {

		dictionaryWords = new ArrayList<String>();

		// Open the dictionary file
		Scanner readFile = new Scanner(new File("C:/Users/Leba Gottesman/Downloads/us/US.dic"));

		while (readFile.hasNext()) { // Read through the file and add the words
										// to the arraylist

			dictionaryWords.add(readFile.nextLine());
		}
	}

	public boolean contains(String word) {

		if (dictionaryWords.contains(word)) // If the dictionary contains the
											// words, return true}

		{
			return true;
		}

		return false;

	}
}