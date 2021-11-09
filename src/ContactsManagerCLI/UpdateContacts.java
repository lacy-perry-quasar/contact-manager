package ContactsManagerCLI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class UpdateContacts {

    public static void addContact() throws IOException {
        String directory = "./src/data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path contactsPath = Paths.get(directory, filename);

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Selection 2: Add a New Contact\n Enter first name.");
        String fisrtName = keyboard.nextLine();
        System.out.println("Enter last name.");
        String lastName = keyboard.nextLine();
        System.out.println("Enter phone number.");
        String phoneNum = keyboard.nextLine();

        Files.write(contactsPath, Arrays.asList(fisrtName + " " + lastName + " | " + phoneNum), StandardOpenOption.APPEND);
    }


}
