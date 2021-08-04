package addressBook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.HashSet;


public class FileOperations {
    private final static String path ="F:/AddressBook.txt";
  
    public void intoFile( HashSet<Person> set){
        StringBuffer buffer=new StringBuffer();
        set.forEach(Person->{
            String personData=Person.toString().concat("\n");
            buffer.append(personData);
        });
        try {
            Files.write(Paths.get(path),buffer.toString().getBytes());
            System.out.println("out");
        } catch (IOException e) {
                       
        }
    }
    public void readFromFile(){
        try {
            Files.lines(new File(path).toPath()).forEach(System.out::println);
            System.out.println("out");
        } catch (IOException e) {
           
            e.printStackTrace();
        }
    }
}
