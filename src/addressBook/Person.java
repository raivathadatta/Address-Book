package addressBook;

public class Person {

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", mail="
				+ mail + ", city=" + city + ", State=" + State + ", Address=" + Address + ", ZipCode=" + ZipCode + "]";
	}
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	private String mail;
	private String city;
	public Person() {	}
	public Person(String firstName, String lastName, String phoneNumber, String mail, String city, String state,
			String address, String zipCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
		this.city = city;
		State = state;
		Address = address;
		ZipCode = zipCode;
	}
	private String State;
	private String Address;
	private String ZipCode;
	public String getZipCode() {
		return ZipCode;
	}
	public void setZipCode(String zipCode) {
	this.ZipCode = zipCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
		
}