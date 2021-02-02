// -------------------------------------------------------
// Assignment 1
// Written by: Brandon Tam 40100539
// For COMP 248 Section U � Winter 2021
// --------------------------------------------------------
/*
 * This programs aims to take a 6-digit NUMBER inputed by the user, and apply encryption to it. 
 * First, it isolates each digit, then it applies unique encryption formula to each. And finally, 
 * it recombines the lone digits to reform the password.
 */

import java.util.Scanner;

public class Encryption {

	public static void main(String[] args) {

		System.out.println(
				"******************************************\n  Welcome to Password Encryption Pro\n******************************************");
		System.out.println("\nPlease enter a 6 digits number");

		// Takes and stores the user input
		final int NUMBER;
		Scanner keyIn = new Scanner(System.in);
		NUMBER = keyIn.nextInt();

		System.out.println("\nGenerating the encrypted password ...");

		// Isolates each digits that need to be encrypted
		int firstDigit = (NUMBER % 1000000 - NUMBER % 100000) / 100000;
		int secondDigit = (NUMBER % 100000 - NUMBER % 10000) / 10000;
		int thirdDigit = (NUMBER % 10000 - NUMBER % 1000) / 1000;
		int fifthDigit = (NUMBER % 100 - NUMBER % 10) / 10;
		int sixthDigit = NUMBER % 10;

		// Encrypts each digit with their respective formula
		int encryptFirstDigit = sixthDigit;
		int encryptSecondDigit = secondDigit % 2;
		int encryptThirdDigit = minusOne(thirdDigit);
		int encryptFourthDigit = fifthDigit;
		int encryptFifthDigit = minusOne(thirdDigit) % 3;
		int encryptSixthDigit = firstDigit;

		// Places each digit in it's position and combines them back into one NUMBER
		int encryptNumber = encryptFirstDigit * 100000 + encryptSecondDigit * 10000 + encryptThirdDigit * 1000
				+ encryptFourthDigit * 100 + encryptFifthDigit * 10 + encryptSixthDigit;

		System.out.println("\nHere is your encrypted password: " + encryptNumber);
		System.out.println("\nThank you for using Password Encryption Pro");

		keyIn.close();
	}

	// Applies logic to prevent 0 value digits from going into the negative
	static int minusOne(int digit) {
		if (digit == 0) {
			return 9;
		}
		return digit - 1;
	}
}
