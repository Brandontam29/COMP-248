import java.util.Scanner;

public class FlightCost {

	public static void main(String[] args) {
		System.out.println("Enter the balance of your air miles?");

		// Declaring variables to be used
		final int COST = 25000;
		int airmiles;
		int flights;
		int balance;

		Scanner keyIn = new Scanner(System.in);
		airmiles = keyIn.nextInt();

		flights = (int) Math.floor(airmiles / COST);
		balance = airmiles - flights * COST;

		System.out.println(
				"\nYou can redeem " + flights + " short haul flights. The balance of your air miles will be " + balance + ".");

		keyIn.close();
	}

}
