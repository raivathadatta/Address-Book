package addressBook;

import java.util.HashSet;

public class AddressBook implements Runnable {
	public void run() {
		
	}
 
	 public static void main(String args[]){    		
		 System.out.println("Welcome To Address Book");
		 AddressBook main =new AddressBook();
	        //Thread thread1 =new Thread(main);
			Book book=new Book();
	        book.menu();
	        // thread1.start();
			// Book book=new Book();
			FileOperations fileOperations=new FileOperations();
			HashSet<Person> set = book.getList();
			fileOperations.intoFile(set);
			fileOperations.readFromFile();
		
			
	   }

}
