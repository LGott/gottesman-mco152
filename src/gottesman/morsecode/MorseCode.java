package gottesman.morsecode;

import java.util.HashMap;

public class MorseCode {

	private String[] morsecode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
			"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

	private char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	HashMap<Character, String> morseMap;
	HashMap<String, Character> engMap;

	public MorseCode() {

	}

	public String encode(String message) {

		morseMap = new HashMap<Character, String>();

		// Add the keys and values into the map
		for (int j = 0; j < alpha.length; j++) {
			morseMap.put(alpha[j], morsecode[j]);
		}

		StringBuilder finalEngMsg = new StringBuilder(5000);

		int i = 0;

		while (i < message.length()) {

			// If word is finished, jump to the next word
			if (message.charAt(i) == ' ') {
				finalEngMsg.append("  ");
				i++;
			}

			// Append the value for the specified key character at specified
			// position
			finalEngMsg.append(morseMap.get(message.charAt(i)));
			i++;
			finalEngMsg.append(" ");

		}

		return finalEngMsg.toString();

	}

	public String decode(String code) {

		engMap = new HashMap<String, Character>();

		// Add the keys and values to the map
		for (int j = 0; j < alpha.length; j++) {
			engMap.put(morsecode[j], alpha[j]);
		}

		StringBuilder finalMorseMsg = new StringBuilder(5000);

		// Split the code by words and letters

		String[] codeWord = code.split("   ");
		String[] codeLetter = new String[100];

		for (int j = 0; j < codeWord.length; j++) {
			codeLetter = codeWord[j].split(" ");
		}

		int i = 0;

		while (i < codeLetter.length) {

			// If word is finished, jump to the next
			if (codeLetter[i].equals("   ")) {
				finalMorseMsg.append(" ");
				i++;
			}

			// Append the value for the specified key character at specified
			// position

			finalMorseMsg.append(engMap.get(codeLetter[i]));
			i++;

		}

		return finalMorseMsg.toString();

	}

}
