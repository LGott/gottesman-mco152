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

	public ScrabbleDictionary() throws IOException {

		dicSet = new HashSet<String>();

		BufferedReader in = new BufferedReader(new FileReader("C:/Users/Leba Gottesman/Downloads/us/US.dic"));

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
