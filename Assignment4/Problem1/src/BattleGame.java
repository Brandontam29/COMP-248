// -------------------------------------------------------
// Assignment 4
// Written by: Brandon Tam 40100539
// For COMP 248 Section U – Winter 2021
// --------------------------------------------------------
//
// This program plays the Battle Game where users face off against each other with their Creatures. The last one standing wins.
//

import java.util.Scanner;

public class BattleGame {

	public static void main(String[] args) {
		System.out.println(
				"******************************************\n        Welcome to the Battle Game\n******************************************");

		// Variable declaration
		Scanner keyIn = new Scanner(System.in);
		int nbrCreature;
		boolean incorrectInput;
		boolean sameTurn;
		boolean gameOngoing = true;

		// Prompt for number of creatures
		do {
			incorrectInput = false;
			System.out.print("How many creatures would you like to have (minimum 2, maximum 8)? ");

			nbrCreature = keyIn.nextInt();

			if (nbrCreature < 2 || nbrCreature > 8) {
				incorrectInput = true;
			}
		} while (incorrectInput);

		// Declare alive and dead creature array
		Creature[] creaturesArray = new Creature[nbrCreature];
		Creature[] losersArray = new Creature[nbrCreature - 1];

		// Create each creature
		keyIn.nextLine();
		for (int i = 0; i < creaturesArray.length; i++) {
			String tempName;
			Creature tempCreature;

			System.out.print("\nWhat is the name of creature " + (i + 1) + "? ");
			tempName = keyIn.nextLine();

			tempCreature = new Creature(tempName);
			creaturesArray[i] = tempCreature;

			seeStatus(tempCreature);
		}

		// Run the game while it is not over
		do {

			// Turns in the game
			for (int i = 0; i < creaturesArray.length; i++) {
				int option;
				Creature curr = creaturesArray[i];

				// Track options that do not end turn
				do {
					sameTurn = false;

					// Prompt for option
					do {
						incorrectInput = false;
						System.out.println(
								"\nCreature #" + (i + 1) + ": " + curr.getName() + ", what would you like to do?");

						System.out.println("1. How many creatures are alive?");
						System.out.println("2. See my status");
						System.out.println("3. See status of all players");
						System.out.println("4. Change my name");
						System.out.println("5. Work for some food");
						System.out.println("6. Attack another creature (Warning!) may turn against you");

						System.out.print("\nYour choice please > ");
						option = keyIn.nextInt();

						if (option < 1 || option > 6) {
							incorrectInput = true;
							System.out.println("\nPlease enter a number between 1 and 6.");
						}
					} while (incorrectInput);

					// Logic of each option
					switch (option) {
					case 1:
						sameTurn = true;
						System.out.println("\nNumber of creatures alive: " + Creature.getNumStillAlive());
						break;

					case 2:
						sameTurn = true;
						seeStatus(curr);
						break;

					case 3:
						sameTurn = true;
						for (int j = 0; j < creaturesArray.length; j++) {
							seeStatus(creaturesArray[j]);
						}

						for (int n = losersArray.length - 1; n >= 0; n--) {
							if (losersArray[n] != null) {
								seeStatus(losersArray[n]);
							}
						}
						break;

					case 4:
						sameTurn = true;
						System.out.println("\nYour current name is " + curr.getName());
						System.out.print("Enter a new name: ");
						keyIn.nextLine();
						String newName = keyIn.nextLine();
						curr.setName(newName);

						break;

					case 5:
						System.out.println("Your status before working for food: " + curr.showStatus());
						int newFoodUnits = curr.earnFood();
						System.out.println("Your status after working for food: " + curr.showStatus()
								+ " ... You earned " + newFoodUnits + " food units.");

						break;

					case 6:
						int target;
						int finalTarget = -1;

						do {
							incorrectInput = false;

							// Choosing attack target
							System.out.print("\nWho do you want to attack? (enter a number from 1 to "
									+ creaturesArray.length + " other than yourself(" + (i + 1) + "): ");
							target = keyIn.nextInt() - 1;

							if (target >= creaturesArray.length || target < 0) {
								incorrectInput = true;
								System.out.println("That creature does not exist. Try again...");
							}

							if (target == i) {
								incorrectInput = true;
								System.out.println("Can't attack yourself silly! Try again...");
							}

						} while (incorrectInput);

						// Processing attack
						if (curr.getFirePowerUnits() < 2) {
							System.out.println(
									"That was not a good idea!!! You only had " + curr.getFirePowerUnits() + "...");

							if (creaturesArray[target].getFirePowerUnits() < 2) {
								System.out.println("Lucky you! The odds were that the other player attacks you, but "
										+ creaturesArray[target].getName()
										+ " doesn't have enough fire power to attack you. So is status quo!!");

							} else {
								finalTarget = i;
								System.out.println(
										"Oh NO!!! You are being attacked by " + creaturesArray[target].getName() + "!");

								System.out.println("Your status before being attacked: " + curr.showStatus());
								creaturesArray[target].attacking(curr);
								System.out.println("Your status after being attacked: " + curr.showStatus());
							}

						} else {
							finalTarget = target;
							System.out.println("\n..... You are attacking " + creaturesArray[target].getName() + "!");
							System.out.println("Your status before attacking: " + curr.showStatus());
							curr.attacking(creaturesArray[target]);
							System.out.println("Your status after attacking: " + curr.showStatus());
						}

						// Moving the dead players to a different array
						if (finalTarget != -1 && !creaturesArray[finalTarget].isAlive()) {
							System.out.println("\n----> " + creaturesArray[finalTarget].getName() + " is dead");
							losersArray[losersArray.length - Creature.getNumStillAlive()] = creaturesArray[finalTarget];
						}
						creaturesArray = removeDeadCreatures(creaturesArray);
						break;
					}

				} while (sameTurn);

				// Check if game is over at the end of every turn
				if (Creature.getNumStillAlive() < 2) {
					gameOngoing = false;
					break;
				}

			}

		} while (gameOngoing);

		// Game over results
		System.out.println("\n!!! GAME OVER !!!");

		System.out.println("\n******************** WINNER ********************");
		seeStatus(creaturesArray[0]);

		System.out.println("\n******************** LOSERS ********************");
		for (int m = losersArray.length - 1; m >= 0; m--) {
			seeStatus(losersArray[m]);
		}

		keyIn.close();
	}

	// Print creature status stylishly
	private static void seeStatus(Creature creature) {
		System.out.println("\nName: " + creature.getName());
		System.out.println("Food units\tHealth units\tFire power units");
		System.out.println("----------\t------------\t----------------");
		System.out.println(
				creature.getFoodUnits() + "\t\t" + creature.getHealthUnits() + "\t\t" + creature.getFirePowerUnits());
		System.out.println("Date created: " + creature.getDateCreated());
		System.out.print("Date died: ");
		System.out.println(creature.getDateDied() == null ? "still alive" : creature.getDateDied());
	}

	// Remove dead creatures not to disturb game flow of alive creatures
	private static Creature[] removeDeadCreatures(Creature[] arr) {
		int newArrLength = 0;
		int arrSpot = 0;

		for (int l = 0; l < arr.length; l++) {
			Creature curr = arr[l];
			if (curr.isAlive()) {
				newArrLength++;
			}
		}

		Creature[] tempArr = new Creature[newArrLength];

		for (int k = 0; k < arr.length; k++) {
			Creature curr = arr[k];
			if (curr.isAlive()) {
				tempArr[arrSpot] = curr;
				arrSpot++;
			}
		}

		return tempArr;
	}
}
