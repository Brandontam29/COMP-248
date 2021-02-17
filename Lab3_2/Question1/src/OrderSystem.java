import java.util.Scanner;

public class OrderSystem {

	public static void main(String[] args) {

		Scanner keyIn = new Scanner(System.in);

		int coffee;
		int burgers;
		int fries;
		int trio = 0;
		int burgerCombo = 0;

		System.out.println("How many cups of coffee?");
		coffee = keyIn.nextInt();

		System.out.println("\nHow many burgers?");
		burgers = keyIn.nextInt();

		System.out.println("\nHow many fries?");
		fries = keyIn.nextInt();

		for (int i = 0; i < coffee + burgers + fries; i++) {

			if (coffee > 0 && burgers > 0 && fries > 0) {
				coffee -= 1;
				burgers -= 1;
				fries -= 1;
				trio += 1;
			} else

			if (coffee == 0 && burgers > 0 && fries > 0) {
				burgers -= 1;
				fries -= 1;
				burgerCombo += 1;
			}

			if (burgers == 0 || fries == 0) {
				break;
			}
		}

		if (trio > 0 && burgerCombo > 0) {
			System.out.println("\nThis order contains some trio combos and some burger combos!");

		} else {

			if (trio == 0) {
				System.out.println("\nNo trio combos from this order!");

				if (burgerCombo > 0) {
					System.out.println("\nOnly burger combos from this order!");
				} else
					System.out.println("\nNo burger combos from this order!");

			} else {

				if (trio > 0 && burgerCombo == 0) {
					System.out.println("\nOnly trio combos from this order!");

				}
			}
		}

		keyIn.close();

	}
}
