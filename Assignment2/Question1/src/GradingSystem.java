// -------------------------------------------------------
// Assignment 1
// Written by: Brandon Tam 40100539
// For COMP 248 Section U – Winter 2021
// --------------------------------------------------------
/*
 * This programs calculates the letter grade based on test score.
 */

import java.util.Scanner;

public class GradingSystem {

	public static void main(String[] args) {

		System.out.println(
				"******************************************\n  Welcome to Grading System Program Pro\n******************************************");

		// Variable declaration
		Scanner keyIn = new Scanner(System.in);

		String name = null;
		int id = -1;
		int score = -1;
		String firstName;
		String lastName;
		String[] letterGrade;

		// Prompt user for name, id, and score
		while (stringAssigned(name)) {
			System.out.println("\nPlease enter your name (Lastname, Firstname seperated by comma): ");
			String pendingName = keyIn.nextLine();
			if (isName(pendingName)) {
				name = pendingName;
			}
		}

		while (id == -1) {
			System.out.println("\nPlease enter your ID without any spaces (7 digits): ");
			int pendingId = keyIn.nextInt();
			if (isId(pendingId)) {
				id = pendingId;
			}
		}

		while (score == -1) {
			System.out.println("\nPlease enter your score (0-100): ");
			int pendingScore = keyIn.nextInt();
			if (isScore(pendingScore)) {
				score = pendingScore;
			}
		}

		// Find first and last name
		int commaSpot = name.indexOf(",");
		firstName = name.substring(0, commaSpot);
		lastName = name.substring(commaSpot + 1, name.length());

		// Display letter grade
		letterGrade = generateLetter(score);

		System.out.println("\n" + firstName + " " + lastName + " got " + score);

		System.out.println("\nBased on the grading system, " + firstName + " (" + id + ") " + "will probably get "
				+ letterGrade[0] + "! " + letterGrade[1]);

		keyIn.close();
	}

	// Check string assigned
	static boolean stringAssigned(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	// Validate input of name, id, and score
	static boolean isName(String name) {
		if (name == null || name.indexOf(",") == -1 || name.length() < 3) {
			return false;
		}
		return true;
	}

	static boolean isId(int integer) {
		if (1000000 <= integer && integer <= 9999999) {
			return true;
		}
		return false;
	}

	static boolean isScore(int integer) {
		if (0 <= integer && integer <= 100) {
			return true;
		}
		return false;
	}

	// Calculate the letter grade and message based on score
	static String[] generateLetter(int score) {

		if (score < 60) {
			String[] grade = { "FNS", "Please work harder to pass the course!" };
			return grade;
		}
		if (score < 70) {
			String[] grade = { "C", "You can do better by more practice!" };
			return grade;
		}

		if (score < 80) {
			String[] grade = { "B", "You are so close to A!" };
			return grade;
		}

		String[] grade = { "A", "Congratulations!" };
		return grade;
	}
}
