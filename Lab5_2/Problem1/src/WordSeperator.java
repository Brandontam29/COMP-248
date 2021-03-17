import java.util.Scanner;

public class WordSeperator {

	public static void main(String[] args) {

		// Variable Declaration
		Scanner keyIn = new Scanner(System.in);
		String word;
		String wordPrint;

		// Prompt input
		System.out.println("Enter a string: ");
		word = keyIn.nextLine();

		// First Print
		wordPrint = word;
		for (int i = 0; i < word.length(); i++) {

			for (int j = 0; j < wordPrint.length(); j++) {
				String letter = wordPrint.substring(j, j + 1);
				System.out.print(letter + "\t");
			}

			wordPrint = word.substring(i + 1);
			System.out.println("");
		}

		// Inverse Print
		for (int a = 1; a < word.length(); a++) {
			wordPrint = word.substring(word.length() - a - 1, word.length());

			for (int b = 0; b < wordPrint.length(); b++) {
				String letter = wordPrint.substring(b, b + 1);
				System.out.print(letter + "\t");
			}

			System.out.println("");
		}

		keyIn.close();
	}

}
