import java.util.*;
import java.io.*;

public class Read_File implements Iterable<String[]>{
    private String filename;
    public Read_File(String filename){
        this.filename = filename;
    }
    /** create and return Iterable object ..*/
    public Iterator<String[]> iterator(){     
       return new File_Iterator(filename);
   }
    
    /** iterator method ..*/
    private class File_Iterator implements Iterator<String[]>{
        private Scanner input;
        private File_Iterator(String filename){
           try{
               input = new Scanner(new File(filename));
           }catch(IOException ex){
                System.out.println("Error I/O file is not found");
                System.exit(1);
           }
       }
       
       /** return boolean, end of the file..*/
       public boolean hasNext(){
           return input.hasNext();
       }
       
       /**return the cursor value to the caller, in split format as array ..*/
       public String[] next(){
           if (this.hasNext()){
               String line = input.nextLine();
               String[] arrayLine = line.split("\\|");
               return arrayLine;
           }else{
                 throw new NoSuchElementException();
           }
       }
    
      /** the remove method is not supported..*/
      public void remove(){
          throw new UnsupportedOperationException();
      }
    }
  }
