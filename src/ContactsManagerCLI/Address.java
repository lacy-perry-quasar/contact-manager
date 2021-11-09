package ContactsManagerCLI;

public class Address {

	protected String streetName;
	protected String cityName;
	protected String stateName;
	protected String addressType;
	protected int streetNumber;
	protected int aptNumber;


	public Address(String streetName, String cityName, String stateName, String addressType, int streetNumber) {

		this.streetName = streetName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.addressType = addressType;
		this.streetNumber = streetNumber;
	}

	public Address(String streetName, String cityName, String stateName, String addressType, int streetNumber, int aptNumber) {

		this.streetName = streetName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.addressType = addressType;
		this.streetNumber = streetNumber;
		this.aptNumber = aptNumber;
	}

	public String getstreetName() {return streetName;}
	public String getcityName() {return cityName;}
	public String getstateName() {return stateName;}
	public String getaddressType() {return addressType;}
	public int getstreetNumber() {return streetNumber;}
	public int getaptNumber() {return aptNumber;}



}
