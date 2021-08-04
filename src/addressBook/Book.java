package addressBook;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import org.json.simple.parser.ParseException;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class Book extends Thread{
	FileOperations fileOperations=new FileOperations();
	public Scanner scanner = new Scanner(System.in);
	public static ArrayList<Person> set = new ArrayList<Person>();
	public FileOperations fileOperations2 =new FileOperations();
	public String getString() {

		String send2 = scanner.nextLine();

		return send2;
	}

	public int getInteger() {
		return scanner.nextInt();
	}

/////////////////////////menu///////////////////////////////////////////
	public synchronized void menu() throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException, ParseException {
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
			System.out.println("9->to write data from csv");
			System.out.println("10->to read into csv");
			System.out.println("11->to read data from json");
			System.out.println("12->to read data from text");
			System.out.println("13->to write data into text");
			
			int key = getInteger();
			switch (key) {
			case 1: {
			fileOperations.addPreson();
				break;
			}
			case 2: {
				updateMenu();
				break;
			}
			case 3: {

				fileOperations.delete();
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
			fileOperations.getPersonByStateOrCityName();
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
			case 9: {
				fileOperations.intoCsvFile("F:/csvFile.csv",set);
				break;
			}
			case 10: {
				fileOperations.readFromCsvFile("F:/csvFile.csv");
				break;
			}
			case 11: {
				fileOperations.readDataFromJson();
				break;
			}
			
		case 12: {
			fileOperations.intoFile(set);
			break;
		}
	case 13: {
		
		fileOperations.readFromFile();
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
	public void viewAllContacts() {
		if (set.equals(null)) {
			System.out.println("your contactList is empty please add contacts  to your Address Boolk");
			// addContact();
		}
		for (Person person : set) {
			System.out.println(person.toString());
		}

	}

/////////////////////////////////////////////////////////////////////////////////
	public void viewSpecificContaact() {
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

			fileOperations.	updatePhoneNumber(name);
				break;
			}
			case 2: {
			fileOperations.	updateMail(name);
				break;

			}
			case 3: {
				fileOperations.	updateAddress(name);
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
	
}
