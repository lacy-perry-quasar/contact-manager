package ContactsManagerCLI;

public class Contact {

	protected String firstName;
	protected String lastName;
	protected String phoneNumber;


	public Contact(String firstName, String lastName, String phoneNumber) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {return firstName + lastName;}
	public String getPhoneNumber() {return phoneNumber;}
}
