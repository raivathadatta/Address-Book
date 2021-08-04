package addressBook;

import java.util.*;
import java.util.stream.Collectors;

public class Book extends Thread{
	FileOperations fileOperations=new FileOperations();
	public Scanner scanner = new Scanner(System.in);
	public ArrayList<Person> set = new ArrayList<Person>();

	public String getString() {

		String send2 = scanner.nextLine();

		return send2;
	}

	public int getInteger() {
		return scanner.nextInt();
	}

/////////////////////////menu///////////////////////////////////////////
	public synchronized void menu() {
		boolean check = true;
		while (check) {

			System.out.println("press 1 add into contact list");
			System.out.println("press 2 update  contact list");
			System.out.println("press 3 to delete contact list");
			System.out.println("perss 4 to view the  spefic contacts");
			System.out.println("press 5 to vew all contacts ");
			System.out.println("Press 6 to get list by CityName or State");
			System.out.println("Press 7 to sort by Name");
			System.out.println("press 8  to exit ");
			int key = getInteger();
			switch (key) {
			case 1: {
				addPreson();
				break;
			}
			case 2: {
				updateMenu();
				break;
			}
			case 3: {

				delete();
				break;
			}
			case 4: {
				viewSpecificContaact();
				break;
			}
			case 5: {
				viewAllContacts();

				break;
			}
			case 6: {
				getPersonByStateOrCityName();
				break;
			}
			case 7: {
				sortByName();
				break;
			}
			case 8: {
				check = false;
				break;
			}

			default:
				return;
			}
		}
	}

	public void sortByName() {
		set.stream().sorted((p1,p2)->p1.getFirstName().compareTo(p2.getFirstName())).forEach(System.out::println);
		}
	
	////////////sortby zipcode///////////////
	public void sortByZipCode() {

		set.stream().sorted((p1,p2)->p1.getAddress().compareTo(p2.getZipCode())) .forEach(System.out::println);

	}

	

	///////////////////////////////////////////////////////////////////
	private void viewAllContacts() {
		if (set.equals(null)) {
			System.out.println("your contactList is empty please add contacts  to your Address Boolk");
			// addContact();
		}
		for (Person person : set) {
			System.out.println(person.toString());
		}

	}

/////////////////////////////////////////////////////////////////////////////////
	private void viewSpecificContaact() {
		System.out.println("enter teh name of contact you need to view");
		scanner.nextLine();
		String name = getString();
		for (Person person : set) {
			if (name.equals(person.getFirstName()) || name.equals(person.getLastName())) {
				System.out.println(person.toString());
			} else {
				System.out.println("the person you want to update is not avilabul ");
			}
		}
	}


///////////////////////////////////////////////////////////////////////////////////////
	private void updateMenu() {
	

		System.out.println("enter the person name to update ");
		scanner.nextLine();
		String name = getString();
		boolean check = true;
		while (check) {
			System.out.println("enter 1 the  update Phone Number");
			System.out.println("enter 2 for update Mailling Address");
			System.out.println("enter 3 to update Address");
			System.out.println("enter 4 to main menu");
			int key = getInteger();

			switch (key) {
			case 1: {

				updatePhoneNumber(name);
				break;
			}
			case 2: {
				updateMail(name);
				break;

			}
			case 3: {
				updateAddress(name);
				break;
			}
			case 4: {
				check = false;
				break;
			}
			default:
				System.err.println("input missmatch plz choose the below numbers");
			}
		}

	}

////////////////////////////////////////////////////////////////////////////////////////////
	private void addPreson() {
		// System.out.println(" enter the person details first name , last name ,phone
		// number , mail , address ");
		Person person = new Person();
		System.out.println("enter the person Firstname");
		scanner.nextLine();
		String name = getString();
		person.setFirstName(name);
		System.out.println("enter the last name");
		person.setLastName(getString());
		System.out.println("enter phone number");
		person.setPhoneNumber(getString());
		System.out.println("enter Mailling Address");
		person.setMail(getString());
		System.out.println("enter city Name");
		person.setCity(getString());
		System.out.println("enter State Name");
		person.setState(getString());
		System.out.println("enter Address");
		String address = getString();
		person.setAddress(address);
		set.add(person);// (person.getFirstName(),person);
		
	}

//////////////////////////////////////////////////////////
	private void updateAddress(String name) {
		// Person person;
		for (Person person1 : set) {
			if (name.equals(person1.getFirstName()) || name.equals(person1.getLastName())) {
				System.out.println("enter address to be changed ");
				person1.setAddress(getString());
			} else
				System.out.println("the person you want to update is not avilabul");

		}
	}

///////////////////////////////////////////////////////////
	public void updatePhoneNumber(String name) {
		// Person person;

		for (Person person : set) {

			if (name.equals(person.getFirstName()) || name.equals(person.getLastName())) {
				System.out.println("enter PhoneNumber to be changed ");
				scanner.nextLine();
				person.setPhoneNumber(getString());
				System.out.println(person.toString());
			} else
				System.out.println("the person you want to update is not avilabul");

		}
	}

///////////////////////////////////////////////////
	private void updateMail(String name) {
		// Person person;
		for (Person person : set) {
			if (name.equals(person.getFirstName()) || name.equals(person.getLastName())) {
				System.out.println("enter Mail to be changed ");
				scanner.nextLine();
				person.setMail(getString());
				System.out.println(person.toString());
			} else
				System.out.println("the person you want to update is not avilabul");

		}
	}

///////////////////////delete///////////////
	private void delete() {
		scanner.nextLine();
		String name = getString();
		for (Person person : set) {
			if (name.equals(person.getLastName()) || name.equals(person.getLastName())) {
				set.remove(person);

			}
		}
	}

///////////////////////checking for duplicate values and removing it from list//////////
	public void getPersonByStateOrCityName() {
		System.out.println("enter the city or state name");
		String name = scanner.next();
		List<Person> list = set.stream().filter(set -> set.getCity().equals(name) || set.getState().equals(name))
				.collect(Collectors.toList());
		for (Person person : list) {
			System.out.println(person.toString());
		}

	}

////////////////////count//////////////////
	public void countDistintCity() {
		System.out.println("enter the city or state name");
		String name = scanner.next();
		long total = set.stream().filter(set -> set.getCity().equals(name) || set.getState().equals(name)).distinct()
				.count();
		System.out.println(total);
	}

	public ArrayList<Person> getList() {
	return set;
    }
}
