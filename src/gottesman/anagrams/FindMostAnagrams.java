package gottesman.anagrams;

import java.io.IOException;
import java.util.ArrayList;

public class FindMostAnagrams {

	public static void main(String[] args) {
		try {

			MostAnagrams findAnagrams = new MostAnagrams();

			//Call the getAnagrams method to return the anagrams into an arrayList
		
			ArrayList<ArrayList<String>> anagramList = 
					findAnagrams.getAnagrams("C:/Users/Leba Gottesman/Downloads/us/US.dic");

			int i = 0;
			int count = 0;

			//Find the largest group of anagrams in the array
			for (ArrayList<String> group : anagramList) {

				if (i < group.size()) {
					
					i = group.size();
					count = i;
				}
			}

			//Print out only the largest anagram group in the arrayList
			
			for (ArrayList<String> group : anagramList) {

				if (group.size() == count) {
					for (String s : group) {

						System.out.print(s + ", ");
					}
					System.out.println();
				}
			}

			System.out.println("\nQuantity of Largest Set: " + count);
		} catch (IOException e) {
			
		}
	}
}
