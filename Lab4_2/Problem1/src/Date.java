import java.util.Scanner;

public class Date {

	public static void main(String[] args) {
		// Variable Declaration
		Scanner keyIn = new Scanner(System.in);
		String date;

		String day;
		String month;
		String year;

		String monthWord = "";
		Boolean startZero = false;

		// Prompt input
		System.out.println("Enter a date in mm-dd-yyyy format:");
		date = keyIn.nextLine();

		// Separate data
		int dashOne = date.indexOf("-");
		int dashTwo = date.lastIndexOf("-");

		month = date.substring(0, dashOne);
		day = date.substring(dashOne + 1, dashTwo);
		year = date.substring(dashTwo + 1, date.length());

		// Look up written month
		monthWord = monthLookUp(month);

		// Remove zero-leading day
		startZero = day.substring(0, 1).equals("0");
		if (startZero) {
			day = day.substring(1, 2);
		}

		// Result
		System.out.println("Date is: " + day + "th of " + monthWord + " " + year);

		keyIn.close();
	}

	static String monthLookUp(String number) {
		String wrdMonth = "";

		switch (number) {
		case "01":
			wrdMonth = "January";
			break;
		case "02":
			wrdMonth = "February";
			break;
		case "03":
			wrdMonth = "March";
			break;
		case "04":
			wrdMonth = "April";
			break;
		case "05":
			wrdMonth = "May";
			break;
		case "06":
			wrdMonth = "June";
			break;
		case "07":
			wrdMonth = "July";
			break;
		case "08":
			wrdMonth = "August";
			break;
		case "09":
			wrdMonth = "September";
			break;
		case "10":
			wrdMonth = "October";
			break;
		case "11":
			wrdMonth = "November";
			break;
		case "12":
			wrdMonth = "December";
			break;
		case "1":
			wrdMonth = "January";
			break;
		case "2":
			wrdMonth = "February";
			break;
		case "3":
			wrdMonth = "March";
			break;
		case "4":
			wrdMonth = "April";
			break;
		case "5":
			wrdMonth = "May";
			break;
		case "6":
			wrdMonth = "June";
			break;
		case "7":
			wrdMonth = "July";
			break;
		case "8":
			wrdMonth = "August";
			break;
		case "9":
			wrdMonth = "September";
			break;
		}

		return wrdMonth;
	}
}
