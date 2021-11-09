package ContactsManagerCLI;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		boolean done = false;
		int selection = 0;
		boolean invalidChoice = false;
		Scanner keyboard = new Scanner(System.in);

		while (!done) {
			// print out menu for the user
			// to select from
			System.out.println("\nPlease select what you would like to do \n");
			System.out.println("1 - View Contacts.");
			System.out.println("2 -  Add a new contact.");
			System.out.println("3 - Search a contact by name.");
			System.out.println("4 - Delete an existing contact.");
			System.out.println("5 - exit\n");

			// read in from the keyboard what
			// the user has entered
			selection = keyboard.nextInt();

			// using nested if statements, determine what
			// operation the user has selected (add, subtract,
			// multiply, etc.)
			if (selection == 1) //view contacts
			{

				invalidChoice = false;
			} else if (selection == 2) //subtract
			{
				invalidChoice = false;
			} else if (selection == 3) //mulitply
			{
				answer1 = number1 * number2;
				invalidChoice = false;
			} else if (selection == 4) //integar division
			{
				answer1 = number1 / number2;
				invalidChoice = false;
			} else if (selection == 5) //exit program
			{
				done = true;
				invalidChoice = false;
			} else    //invalid choice
			{
				invalidChoice = true;
				System.out.println("\n***ERROR*** " +
						selection +
						"is not a valid selection. " +
						"Please try again!");
			}

			// using nested if statements, determine
			// the type of output to produce
			if (selection == 5 && invalidChoice == false) {
				System.out.println("\nCalculated answer is: " +
						answer2);
			} else if (selection != 6 && invalidChoice == false) {
				System.out.println("\nCalculated answer is: " +
						answer1);
			} else {
				System.out.println("\nNo calculation done.");
			}
		}    //end wile loop
	}
}
