package addressBook;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBook implements Runnable {
	// public void run() {
		
	// }
 
	 public static void main(String args[]) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException, ParseException{    		
		 System.out.println("Welcome To Address Book");
		 //AddressBook main1 =new AddressBook();
	        //Thread thread1 =new Thread(main);
			Book book=new Book();
	        book.menu();
	       
		
			
	   }

	@Override
	public void run() {
		
		
	}

}
