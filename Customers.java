import java.util.*;
public class Customers extends BuildStructure<Customer>{
    
    public Customers(String filename){
        super(filename);
    }

    protected Customer makeObject(int id, String name){
        Customer m = new Customer(id, name);
        return m;
    }

}//end Movies class

