import java.util.Scanner;

public class TriangleChecker {

	public static void main(String[] args) {
		System.out.println("Entering three internal angles:");

		final String ANGLES;
		int angleOne;
		int angleTwo;
		int angleThree;

		Scanner keyIn = new Scanner(System.in);
		ANGLES = keyIn.nextLine();

		int firstSpace = ANGLES.indexOf(" ");
		int secondSpace = ANGLES.lastIndexOf(" ");

		angleOne = Integer.parseInt(ANGLES.substring(0, firstSpace));
		angleTwo = Integer.parseInt(ANGLES.substring(firstSpace + 1, secondSpace));
		angleThree = Integer.parseInt(ANGLES.substring(secondSpace + 1, ANGLES.length()));

		System.out.println("\n");

		if (angleOne == 90 || angleTwo == 90 || angleThree == 90)
			System.out.println("\nThis might be a right triangle!");

		if (angleOne <= 90 || angleTwo <= 90 || angleThree <= 90)
			System.out.println("\nThis might be an obtuse triangle!");

		if (angleOne >= 90 || angleTwo >= 90 || angleThree >= 90)
			System.out.println("\nThis might be an acute triangle!");

		if (angleOne + angleTwo + angleThree != 180)
			System.out.println("\nThis turns out to be an invalid triangle!");

		System.out.println("\nFinished!");

		keyIn.close();

	}
}
