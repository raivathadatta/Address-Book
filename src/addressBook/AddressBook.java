package addressBook;

import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBook implements Runnable {
	// public void run() {
		
	// }
 
	 public static void main(String args[]) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException{    		
		 System.out.println("Welcome To Address Book");
		 //AddressBook main1 =new AddressBook();
	        //Thread thread1 =new Thread(main);
			Book book=new Book();
	        book.menu();
	        // thread1.start();
			// Book book=new Book();
			FileOperations fileOperations=new FileOperations();
			ArrayList<Person> set = book.getList();
			fileOperations.intoFile(set);
			fileOperations.readFromFile();
			
			fileOperations.intoCsvFile("F:/csvFile.csv",set);
		
			fileOperations.readFromCsvFile("F:/csvFile.csv");
			/*fileOperations*/
		
			
	   }

	@Override
	public void run() {
		
		
	}

}
