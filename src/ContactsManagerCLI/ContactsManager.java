package ContactsManagerCLI;

import javax.swing.text.MaskFormatter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

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
            } else if (selection == 2)
            {
                addContact();
            } else if (selection == 3)
            {

            } else if (selection == 4)
            {
                deleteContact();
            } else if (selection == 5) //exit program
            {
                done = true;
            } else    //invalid choice
            {
                invalidChoice = true;
                System.out.println("\n***ERROR*** " + selection + "is not a valid selection. " + "Please try again!");
            }
        }
    }

    public static void showContacts() throws IOException {
        System.out.println("1 - View Contacts.");
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
        System.out.println("Enter your First name.");
        String firstName = scanner.nextLine();
        firstName = firstName.replaceAll(" ","");
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

        List<String> contactsList = Arrays.asList(contact);
        Files.write(contactsTxtPath, contactsList, StandardOpenOption.APPEND);

    }

    public static void deleteContact() throws IOException {
        System.out.println("4 - Delete an existing contact.");
        System.out.println("Which contact would you like to delete?");
        showContacts();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter A Full Name");
        String deleteUser = scanner.nextLine();

        List<String> printList = Files.readAllLines(contactsTxtPath);
        printList.removeIf(c -> c.contains(deleteUser));

        System.out.println("printList = " + printList);
        System.out.println("You have deleted " + deleteUser + " from the contact list!" );
        Files.write(contactsTxtPath, printList);

    }




}
