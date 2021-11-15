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

	public String getName() {return firstName + " " + lastName;}
	public String getPhoneNumber() {return phoneNumber;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName =lastName;}
	public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

	public static void main(String[] args) {
		Contact steve = new Contact("Steven", "Lacy", "222-222-2222");
		Contact rod = new Contact("Rodriques", "Perry", "333-333-3333");
		Contact ken = new Contact("Kenneth", "Howell", "444-444-4444");

		System.out.println("steve.getName() = " + steve.getName());
		System.out.println("rod.getName() = " + rod.getName());
		System.out.println("ken.getName() = " + ken.getName());

	}








}
