package ContactsManagerCLI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsManager {

    public static String directory = "./src/data/";
    public static String filename = "contacts.txt";
    public static Path dataDirectory = Paths.get(directory);
    public static Path contactsTxtPath = Paths.get(directory, filename);

    public static void showMenu() throws IOException {
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
        System.out.println("2 -  Add a new contact.");
        System.out.println("3 - Search a contact by name.");
        System.out.println("4 - Delete an existing contact.");
        System.out.println("5 - exit\n");

        // read in from the keyboard what the user has entered
        selection = keyboard.nextInt();

        if (selection == 1) //view contacts
        {
            showContacts();
            invalidChoice = false;
        } else if (selection == 2)
        {
            addContact();
            invalidChoice = false;
        } else if (selection == 3) //mulitply
        {

            invalidChoice = false;
        } else if (selection == 4) //integar division
        {

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

    }


    }

    public static void showContacts() throws IOException {

        List<String> printList = Files.readAllLines(contactsTxtPath);
        for (int i = 0; i < printList.size(); i++) {
//            System.out.println((i + 1) + ": " + printList.get(i));
        }
        System.out.println(printList);
    }

    public static void addContact() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your First name.");
        String firstName = scanner.nextLine();
        System.out.println("Enter your Last name.");
        String lastName = scanner.nextLine();
        System.out.println("Enter your phone number.");
        String phone = scanner.nextLine();
        String contact = firstName + " " + lastName + " | " + phone;

        List<String> contactsList = Arrays.asList(contact);

    }




}
