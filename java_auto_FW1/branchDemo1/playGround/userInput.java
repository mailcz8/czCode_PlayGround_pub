package playGround;

import java.util.Scanner;

import javax.xml.transform.OutputKeys;

public class userInput {

	public static void main(String[] args) {

		int value, val;
		/*
		 * System.out.println("Please enter something: "); Scanner input = new
		 * Scanner(System.in); int value = input.nextInt();
		 * System.out.println("Please enter a number: " + value);
		 * 
		 * while (value != 5) { Scanner input = new Scanner(System.in);
		 * System.out.println("Please enter a number: " + value); value =
		 * input.nextInt(); }
		 * 
		 * do { System.out.println("Please enter something: "); Scanner input =
		 * new Scanner(System.in); value = input.nextInt(); val =
		 * OutputKeys.INDENT.length(); } while(value != 5);
		 * System.out.println("You got 5! You are DONE!!!");
		 */
		Scanner input = new Scanner(System.in);
		System.out.println("please enter a comand: ");
		String text = input.nextLine();

		switch (text) {
		case "yes|Yes":
			System.out.println("Machine started!");
			break;
		case "end":
			System.out.println("Machine stopped.");
			break;
		default:
			System.out.println("Command not recongized!");

		}
	}
}
