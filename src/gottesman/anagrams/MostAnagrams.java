package gottesman.anagrams;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostAnagrams {

	public MostAnagrams() {
	}

	public ArrayList<String> fileRead(String fileName) throws IOException {

		Scanner readFile = new Scanner(new File(fileName));

		ArrayList<String> dicWords = new ArrayList<String>();

		// Read the file into the dicWords arrayList

		while (readFile.hasNext()) {
           dicWords.add(readFile.next());
		}
		return dicWords;
	}

	public ArrayList<ArrayList<String>> getAnagrams(String fileName) throws IOException {

		//Create a new HashMap where the value of each key (key =specific letters), is an 
		//arrayList of anagrams for those letters
		
		Map<String, ArrayList<String>> listOfAnagrams = new HashMap<String, ArrayList<String>>();
		
		//return the arrayList of dictionary words into an arrayList
		
		ArrayList<String> listOfWords = fileRead(fileName);

		//Place each word into a char array in order to sort the letters alphabetically. 
		//(So that the words can be compared in order to find anagrams)
		
		for (String s : listOfWords) {
			char[] c = s.toUpperCase().toCharArray();
			Arrays.sort(c);
			
			//Retrieve the value of the key from the HashMap. If null, then create a new ArrayList for the map.
			//Add the word into the new list or the existing list
			
			ArrayList<String> keyValues = listOfAnagrams.get(String.valueOf(c));
		    if (keyValues == null) {
				keyValues = new ArrayList<String>();
			}
			
			keyValues.add(s);
			
			//Put the keys and values into the HashMap
			listOfAnagrams.put(String.valueOf(c), keyValues);
		}
		
		//If a value contains only one word in it's list, then it obviously does not have any anagrams, so we do not 
		//want to return those words as part of the list, and therefore return only values that are greater than 1
		
		ArrayList<ArrayList<String>> anagrams = new ArrayList<ArrayList<String>>();
		for (Map.Entry<String, ArrayList<String>> entry : listOfAnagrams.entrySet()) {
			if (entry.getValue().size() > 1) {
				anagrams.add(entry.getValue());
			}
		}
		return anagrams;
	}

}
