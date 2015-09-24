package gottesman.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ScrabbleDictionary {

	String word;
	ArrayList<String> dictionaryWords;
	Set<String> dicSet;

	public ScrabbleDictionary() throws FileNotFoundException {

		dicSet = new HashSet<String>();
        dictionaryWords = new ArrayList<String>();

		// Open the dictionary file
		Scanner readFile = new Scanner(new File("C:/Users/Leba Gottesman/Downloads/us/US.dic"));

		while (readFile.hasNext()) { // Read through the file and add the words
										// to the arraylist

			dictionaryWords.add(readFile.nextLine());
		}

		for (String dicWord : dictionaryWords) {

			dicSet.add(dicWord);  //Add the words to the set

		}
	}

	public boolean contains(String word) {
 
		// If the dictionary contains the words,return true
									
	   return dicSet.contains(word);
	
    }
}
