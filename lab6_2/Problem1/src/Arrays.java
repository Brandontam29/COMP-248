import java.util.Scanner;

public class Arrays {

	public static void main(String[] args) {
		// Variable Declaration

		String input;
		String[] words = new String[5];
		Scanner keyIn = new Scanner(System.in);

		// Prompt input
		System.out.println("Enter 5 words:");
		input = keyIn.nextLine();

		// Build Array
		input = input + " ";
		for (int h = 0; h < 5; h += 1) {
			int spaceIndex = input.indexOf(" ");
			String wordArray = input.substring(0, spaceIndex);
			words[h] = wordArray;
			input = input.substring(spaceIndex + 1, input.length());
		}

		// Print Results
		for (int j = 0; j < words.length; j += 1) {
			int wordLength = words[j].length();
			String wordPrint = words[j].substring(0, wordLength - 1);

			// Print Tabs
			for (int k = 0; k < (5 - j - 1); k += 1) {
				System.out.print("\t");
			}

			// Print Words
			for (int l = 0; l < (j + 1); l += 1) {
				System.out.print(wordPrint + "*\t");
			}

			System.out.println();
		}

		// Use for Testing
		// aaa bbb ccc ddd eee
		// aaa bbb cccc ddd eeeeee

		keyIn.close();
	}

}
