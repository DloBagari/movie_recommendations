import java.util.*;
public class Customer extends Widget{
    private Map<Movie, Integer> rates = new HashMap<>();
    public Customer(int id, String name){
        super(id, name);
    }
    
    public void putMovie(Movie movie, int rate){
        rates.put(movie, rate);
    }
    
    public Collection<Movie> getRated(){
        return rates.keySet();
    }
    
    public int get(Movie movie) throws Exception{
        if (rates.containsKey(movie)){
            return rates.get(movie);
        }else{
            throw new Exception("no such key found");
       }
    }
}
