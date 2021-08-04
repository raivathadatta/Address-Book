package addressBook;

import java.io.File;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.parser.*;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import org.*;

public class FileOperations extends Book{
	public String getString() {

		String send2 = scanner.nextLine();

		return send2;
	}

	public int getInteger() {
		return scanner.nextInt();
	}

	Scanner scanner =new Scanner(System.in);
	private final static String path = "F:/AddressBook.txt";
	ArrayList<Person> retriveList = new ArrayList<Person>();
//	ArrayList<Person> set = new ArrayList<>();
	
	public void intoFile(ArrayList<Person> set) {
		StringBuffer buffer = new StringBuffer();
		set.forEach(Person -> {
			String personData = Person.toString().concat("\n");
			buffer.append(personData);
		});
		try {
			Files.write(Paths.get(path), buffer.toString().getBytes());
			System.out.println("out");
		} catch (IOException e) {

		}
	}

	public void readFromFile() {
		try {
			Files.lines(new File(path).toPath()).forEach(System.out::println);
			System.out.println("out");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void readFromCsvFile(String path) throws FileNotFoundException {
		System.out.println("out put from csv file");
		Scanner sc = new Scanner(new File(path));
		sc.useDelimiter(",");
		while (sc.hasNext()) {
			System.out.print(sc.next());
		}
		sc.close();
	}

	public void intoCsvFile(String path, ArrayList<Person> list)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		FileWriter outputfile = new FileWriter(path);

		CSVWriter writer = new CSVWriter(outputfile);

		writer.close();
	}

	public void readDataFromJson() throws FileNotFoundException, IOException, ParseException {
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("F:/person.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray personList = (JSONArray) obj;
			System.out.println(personList);

			// Iterate over employee array
			personList.forEach(person -> parsePersonObject((JSONObject) person));
			personList.forEach(person -> set.add((Person) person));
		}

	}

	private static void parsePersonObject(JSONObject person) {
		// Get employee object within list
		JSONObject employeeObject = (JSONObject) person.get("employee");

		// Get employee first name
		String firstName = (String) person.get("firstName");
		System.out.println(firstName);

		// Get employee last name
		String lastName = (String) person.get("lastName");
		System.out.println(lastName);

		String phoneNumber = (String) person.get("phoneNumber");
		System.out.println(phoneNumber);
		String mail = (String) person.get("mail");
		System.out.println(mail);
		String city = (String) person.get("city");
		System.out.println(city);
		String State = (String) person.get("State");
		System.out.println(State);
		String Address = (String) person.get("Address");
		System.out.println(State);
		String ZipCode = (String) person.get("ZipCode");
		System.out.println(ZipCode);
	}


	public void addPreson() {
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
	public void updateAddress(String name) {
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
	public void updateMail(String name) {
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
	public void delete() {
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
