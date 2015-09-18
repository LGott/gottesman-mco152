package gottesman.morsecode;

public class MorseCode {

	private String[] morsecode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
			"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

	private char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public MorseCode() {

	}

	public String encode(String message) {

		String morseMsg = ""; // String for the final encoded message

		for (int i = 0; i < message.length(); i++) {

			if (message.charAt(i) == ' ') { // If blank, add a space

				morseMsg += " ";
			}
			for (int j = 0; j < alpha.length; j++) {

				if (message.charAt(i) == alpha[j]) { // Compare the letters

					if (i < message.length() - 1)
						morseMsg += morsecode[j] + " ";

					else
						morseMsg += morsecode[j]; // Add the morsecode value to
													// the string
				}

			}
		}

		return morseMsg;

	}

	public String decode(String code) {

		String engMsg = "";

		// Split by word, and then by letter
		String[] codeWord = code.split("  ");
		String[] codeLetter = new String[100];

		for (int j = 0; j < codeWord.length; j++) {
			codeLetter = codeWord[j].split(" ");

			for (int x = 0; x < codeLetter.length; x++) {
				for (int p = 0; p < morsecode.length; p++) {

					if (codeLetter[x].equalsIgnoreCase(morsecode[p])) {

						engMsg += alpha[p]; // add the letter value to the
											// string
					}

				}
			}
			if (j < codeWord.length - 1) {
				engMsg += " "; // add a space
			}

		}

		return engMsg;
	}
}
