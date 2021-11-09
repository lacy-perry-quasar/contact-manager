package ContactsManagerCLI;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Contact {

	protected String firstName;
	protected String lastName;
	protected String phoneNumber;


	public Contact(String firstName, String lastName, String phoneNumber) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}


//	public String getName() {return firstName + lastName;}
//	public String getPhoneNumber() {return phoneNumber;}
//	public void setFirstName(String firstName) {this.firstName = firstName;}
//	public void setLastName(String lastName) {this.lastName =lastName;}
//	public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}


}
