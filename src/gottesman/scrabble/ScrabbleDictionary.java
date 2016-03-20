package gottesman.scrabble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ScrabbleDictionary {

	String word;
	ArrayList<String> dictionary;
	Set<String> dicSet;
	String line;

	private static ScrabbleDictionary singleton;

	public static ScrabbleDictionary getInstance() throws IOException {

		if (singleton == null) {

			singleton = new ScrabbleDictionary();
		}

		return singleton;
	}

	// Make the constructor private so that no one can make a new instance and
	// can only use the singleton one
	public ScrabbleDictionary() throws IOException {

		dicSet = new HashSet<String>();

		BufferedReader in = new BufferedReader(new FileReader("./US.dic"));

		dictionary = new ArrayList<String>();

		while ((line = in.readLine()) != null)

		{
			dictionary.add(line);
		}

		in.close();

		for (String dicWord : dictionary) {

			dicSet.add(dicWord); // Add the words to the set

		}
	}

	public boolean contains(String word) {

		// If the dictionary contains the words,return true

		return dicSet.contains(word);

	}
}
