package addressBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import com.opencsv.*;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class FileOperations {
    private final static String path ="F:/AddressBook.txt";
    ArrayList<Person> retriveList =new ArrayList<Person>();
  
    public void intoFile( ArrayList<Person> set){
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
    
    public void readFromCsvFile(String path) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(path));  
        sc.useDelimiter(",");   //sets the delimiter pattern  
        while (sc.hasNext())  //returns a boolean value  
        {  
        System.out.print(sc.next());  //find and returns the next complete token from this scanner  
        }   
        sc.close();  //closes the scanner  
        }  
        // try{
        //  Reader reader =Files.newBufferedReader(Paths.get(path));
        //  CSVReader read =new CSVReader(reader);
        // while(read.readNext()!=null){
           
        //     String[] dataRecord =new String[8];
        //     dataRecord=read.readNext();
        //    retriveList.add(new Person( dataRecord[0], dataRecord[1], dataRecord[2], dataRecord[3], dataRecord[4], dataRecord[5], dataRecord[6], dataRecord[7]));

        // }
        // read.close();

        // }
        // catch (Exception e){
        //     System.out.println(e);
        // }
        // for (Person person : retriveList) {
        //     person.toString();
        // }
        

    public void intoCsvFile(String path,ArrayList<Person> list) throws IOException,
     CsvDataTypeMismatchException, CsvRequiredFieldEmptyException{
        FileWriter outputfile = new FileWriter(path);
  
 
        CSVWriter writer = new CSVWriter(outputfile);
  
        
     
  
       
        writer.close();
    }
}
