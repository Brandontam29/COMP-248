// -------------------------------------------------------
// Assignment 1
// Written by: Brandon Tam 40100539
// For COMP 248 Section U – Winter 2021
// --------------------------------------------------------
/*
 * This program calculates the cost of a restaurant order.
 */

import java.util.Scanner;

public class OnlineOrder {

	public static void main(String[] args) {

		// Variable Declaration
		Scanner keyIn = new Scanner(System.in);

		int menuOption;
		String choice = "";
		float price = 0f;
		String addMeat;
		String meatChoice;
		boolean isWrongAnswer;
		String addFood;
		boolean moreFood;
		boolean exit = false;

		System.out.println(
				"******************************************\n  Welcome to Grading System Program Pro\n******************************************");
		System.out.println(
				"   1. Hamburger\n   2. Pizza \n   3. Noodle\n   4. Salad\n   5. Sandwich\n   6. Exit\n******************************************");

		// Add more food wrapper
		do {
			moreFood = false;

			// Prompt for menu item
			System.out.println("\nPlease enter your choice (1-6)");
			do {
				isWrongAnswer = false;
				menuOption = keyIn.nextInt();
				switch (menuOption) {
				case 1:
					choice = "Hamburger";
					break;
				case 2:
					choice = "Pizza";
					break;
				case 3:
					choice = "Noodle";
					break;
				case 4:
					choice = "Salad";
					break;
				case 5:
					choice = "Sandwich";
					break;
				case 6:
					choice = "Finish your order!";
					System.out.println("\nYour choice is: " + choice);
					exit = true;
					break;
				default:
					System.out.println("\nPlease enter your choice (1-6)");
					isWrongAnswer = true;
				}
			} while (isWrongAnswer);
			keyIn.nextLine();

			// Skip if choice is exit
			if (!exit) {
				System.out.println("\nYour choice is: " + choice + ".");
				System.out.println("Would you like some meat with your " + choice + "?");

				// Prompt for adding meat
				do {
					isWrongAnswer = false;
					addMeat = keyIn.nextLine();

					if (addMeat.equals("Yes") || addMeat.equals("yes")) {

						// Prompt for meat type
						System.out.println("\nBeef or Pork");
						do {
							isWrongAnswer = false;
							meatChoice = keyIn.nextLine();

							if (meatChoice.equals("Beef") || meatChoice.equals("beef")) {
								choice = "";
								addMeat = "";
								price += 25.5f;
								meatChoice = "";
							}

							if (meatChoice.equals("Pork") || meatChoice.equals("pork")) {
								choice = "";
								addMeat = "";
								price += 17.5f;
								meatChoice = "";
							} else {
								System.out.println("\nBeef or Pork");
								isWrongAnswer = true;
							}
						} while (isWrongAnswer);
					} else {
						if (addMeat.equals("No") || addMeat.equals("no")) {
							choice = "";
							addMeat = "";
							price += 7.5f;
						} else {
							System.out.println("\nWould you like some meat with your " + choice + "?");
							isWrongAnswer = true;
						}
					}
				} while (isWrongAnswer);

				// Prompt for more food
				System.out.println("\nWould you like more food?");
				do {
					isWrongAnswer = false;
					addFood = keyIn.nextLine();

					if (addFood.equals("Yes") || addFood.equals("yes")) {
						moreFood = true;
					} else {
						if (addFood.equals("No") || addFood.equals("no")) {
							moreFood = false;
						} else {
							System.out.println("\nWould you like more food?");
							isWrongAnswer = true;
						}
					}
				} while (isWrongAnswer);
			}
		} while (moreFood);

		// Check out and calculate delivery
		if (price < 50 && price != 0) {
			System.out.println("\nThe total price is less than 50$. 5$ fee will be applied.");
			price += 5;
		} else {
			System.out.println("\nNo need to pay the delivery fee.");
		}

		// Ask for tips
		if (price != 0) {
			System.out.println("\nWould you like to tip? Please enter the amount: ");
			price += keyIn.nextFloat();
		}

		// Total price and closing message
		System.out.println("\nThe total price is $" + price);
		System.out.println("\nThank you for using Online Order Program");

		keyIn.close();

	}
}
