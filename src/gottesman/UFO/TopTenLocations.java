package gottesman.UFO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class TopTenLocations implements Comparator<ArrayList<String>> {

	public static void main(String[] args) throws IOException {

		FindTopTen find = new FindTopTen();
		try {
			ArrayList<ArrayList<String>> locations = find
					.topTen("C:/Users/Leba Gottesman/Documents/Touro College/gottesman-mco152/ufo_awesome.json");

			// Create a Comparator class so that the Array can be sorted

			class stringComparator implements Comparator<ArrayList<String>> {
				@Override
				public int compare(ArrayList<String> a, ArrayList<String> b) {
					if (a.size() < b.size()) {
						return -1;
					}
					if (a.size() > b.size()) {
						return 1;
					} else {
						return 0;
					}
				}
			}

			/*
			 * In order to get the top ten locations, sort the
			 * ArrayList<ArrayList<String>> of locations according to the size
			 * of each location array (reversed), so that the first ten
			 * positions in the array are the top ten locations.
			 */

			Collections.sort(locations, new stringComparator().reversed());

			// Print out the first ten positions in the array
			for (int i = 0; i < 10; i++) {

				System.out.println(locations.get(i).get(0) + ": " + locations.get(i).size() + " UFO Sightings");
			}
		} catch (IOException e1) {
		}
	}

	@Override
	public int compare(ArrayList<String> o1, ArrayList<String> o2) {
		return 0;
	}
}

class FindTopTen {

	public ArrayList<ArrayList<String>> topTen(String jsonFile) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader(jsonFile));

		final Gson gson = new Gson();

		// Read in the JSON File
		final UFOSightingList list = gson.fromJson(in, UFOSightingList.class);

		in.close();

		// Create a map that has a String key and an ArrayList of the key value
		Map<String, ArrayList<String>> locationsMap = new HashMap<String, ArrayList<String>>();

		for (UFOSighting sight : list) {

			// Place the location into a char array
			char[] c = sight.getLocation().toUpperCase().trim().toCharArray();

			// Retrieve the value of the key from the HashMap. If null, then
			// create a new ArrayList for the map.
			// Add the word into the new list or the existing list

			ArrayList<String> values = locationsMap.get(String.valueOf(c));

			if (values == null) {
				values = new ArrayList<String>();
			}

			values.add(sight.getLocation());

			// Put the keys and values into the HashMap
			locationsMap.put(String.valueOf(c), values);
		}

		// Place the values into an arrayList and return it
		ArrayList<ArrayList<String>> locations = new ArrayList<ArrayList<String>>();
		for (Map.Entry<String, ArrayList<String>> entry : locationsMap.entrySet()) {
			if (entry.getValue().size() >= 1) {
				locations.add(entry.getValue());
			}
		}
		return locations;
	}

}
