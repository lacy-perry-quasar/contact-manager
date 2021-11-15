package ContactsManagerCLI;

import javax.swing.text.MaskFormatter;
import java.io.IOException;
import java.nio.file.*;
import java.text.ParseException;
import java.util.*;


public class ContactsManager {

	public static String directory = "./src/data/";
	public static String filename = "contacts.txt";
	public static Path dataDirectory = Paths.get(directory);
	public static Path contactsTxtPath = Paths.get(directory, filename);

	public static void showMenu() throws IOException, ParseException {
		Scanner keyboard = new Scanner(System.in);
		boolean done = false;
		int selection = 0;
		boolean invalidChoice = false;

		if (Files.notExists(dataDirectory)) {
			Files.createDirectory(dataDirectory);
		}

		if (Files.notExists(contactsTxtPath)) {
			Files.createFile(contactsTxtPath);
		}

		while (!done) {
			System.out.println("\nPlease select what you would like to do \n");
			System.out.println("1 - View Contacts.");
			System.out.println("2 - Add a new contact.");
			System.out.println("3 - Search a contact by name.");
			System.out.println("4 - Delete an existing contact.");
			System.out.println("5 - exit\n");

			// read in from the keyboard what the user has entered
			selection = keyboard.nextInt();

			if (selection == 1) //view contacts
			{
				showContacts();
			} else if (selection == 2) // add new contact
			{
				addContact();
			} else if (selection == 3)  //search for contact
			{
				searchContact();
			} else if (selection == 4)  //delete contact
			{
				deleteContact();
			} else if (selection == 5) //exit program
			{
				System.out.println("Thanks for using contact manager.");
				done = true;
			} else    //invalid choice
			{
				invalidChoice = true;
				System.out.println("\n***ERROR*** " + selection + " is not a valid selection. " + "Please try again!");
			}
		}
	}


	public static void showContacts() throws IOException {
		List<String> printList = Files.readAllLines(contactsTxtPath);
		System.out.println("Name | Phone number");
		System.out.println("--------------------");
		for (int i = 0; i < printList.size(); i++) {

			System.out.println((i + 1) + ": " + printList.get(i));
		}

	}

	public static void addContact() throws IOException, ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("2 - Add a new contact.");
		String firstName = "";

		System.out.println("Enter your First name.");
		firstName = scanner.nextLine();
		firstName = firstName.replaceAll(" ", "");
		System.out.println("Enter your Last name.");
		String lastName = scanner.nextLine();
		lastName = lastName.replaceAll(" ", "");
		System.out.println("Enter your phone number. No spaces or dashes");
		String phoneMask = "###-###-####";
		String phone = scanner.nextLine();
		MaskFormatter maskFormatter = new MaskFormatter(phoneMask);
		maskFormatter.setValueContainsLiteralCharacters(false);
		phone = maskFormatter.valueToString(phone);
		String contact = firstName + " " + lastName + " | " + phone;
		List<String> contactsList = List.of(contact);
		Files.write(contactsTxtPath, contactsList, StandardOpenOption.APPEND);
		showContacts();


	}

	public static void deleteContact() throws IOException {
		System.out.println("4 - Delete an existing contact.");
		System.out.println("Which contact would you like to delete?");
		showContacts();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter A Full Name");
		String deleteUser = scanner.nextLine();

		List<String> printList = Files.readAllLines(contactsTxtPath);


//https:www.baeldung.com/java-collection-remove-elements ~ removeIf()
		printList.removeIf(c -> c.contains(deleteUser));


		System.out.println("You have deleted " + deleteUser + " from the contact list!");
		Files.write(contactsTxtPath, printList);

	}

	public static void searchContact() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("3 - Search a contact by name.");
		System.out.println("Please Enter A Full Name");
		String deleteUser = scanner.nextLine();

		List<String> printList = Files.readAllLines(contactsTxtPath);

		for (String contact : printList) {
			if (contact.contains(deleteUser)) {
				System.out.println("Name | Phone number");
				System.out.println("--------------------");
				System.out.println(contact);
			}

		}

	}


}
