import java.util.*;
public class Movie extends Widget{
    private Set<Customer> ratedBy = new HashSet<>();
    public Movie(int id, String name){
        super(id, name);
    }
    
    public void add(Customer customer){
        ratedBy.add(customer);
    }
    
    public Set<Customer> getRatedBy(){
        return ratedBy;
    }
}

