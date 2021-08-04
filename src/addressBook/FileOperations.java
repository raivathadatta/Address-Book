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
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.parser.*;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import org.*;

public class FileOperations extends Book {
	public String getString() {

		String send2 = scanner.nextLine();

		return send2;
	}

	public int getInteger() {
		return scanner.nextInt();
	}

	Scanner scanner = new Scanner(System.in);
	private final static String path = "F:/AddressBook.txt";


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
//////read from text file 
	public void readFromFile() {
		try {
			Files.lines(new File(path).toPath()).forEach(System.out::println);
			System.out.println("out");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
///////read data from csv file
	public void readFromCsvFile(String path) throws FileNotFoundException {
		System.out.println("out put from csv file");
		Scanner sc = new Scanner(new File(path));
		sc.useDelimiter(",");
		while (sc.hasNext()) {
			System.out.print(sc.next());
		}
		sc.close();
	}
////////////write into csv file////
	public void intoCsvFile(String path, ArrayList<Person> list)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
	
		System.out.println("hai");
		
		File file = new File(path);
		
		if(!file.exists())
			file.createNewFile();
		
		System.out.println(path);
		
		System.out.println("file created");
		
		FileWriter outputfile = new FileWriter(path);

		CSVWriter writer = new CSVWriter(outputfile);

		writer.close();
	}
///////read from json file////////
	public void readDataFromJson(String path) throws FileNotFoundException, IOException, ParseException {
		File file = new File(path);
		
		if(!file.exists())
			file.createNewFile();
		JSONParser parser = new JSONParser();

		Object obj = parser.parse(new FileReader(path));

		JSONObject jsonObject = (JSONObject) obj;

		JSONArray list = (JSONArray) jsonObject.get("PersonsList");

		list.stream().forEach(person -> list.add(person));

	}

	
////////////////////////////////add person to list //////////////////////////////////

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

//////////////////////update ////////////////////////////////////
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
