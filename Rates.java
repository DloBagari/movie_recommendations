import java.util.*;
public class Rates{
    private Movies movies;
    private Customers customers;
    public Rates( String filename, Movies movies, Customers customers){
        this.movies = movies;
        this.customers = customers;
        Read_File file = new Read_File(filename);
        Iterator<String[]> iter = file.iterator();
        while (iter.hasNext()){
            String[] rate = iter.next();
            if (rate.length == 3){
                 try{
                    int customer = Integer.parseInt(rate[0]);
                    int movie = Integer.parseInt(rate[1]);
                    int rated = Integer.parseInt(rate[2]);
                    STORE_INFO(customer,movie, rated);
                 }catch(NumberFormatException ex){
                       System.out.println("Skipped a Line: String can not be converted to Integer");                }
            }
        }
    }
   
    
    private void STORE_INFO(int c, int m, int r){
        Customer customer = customers.getObject(c);
        Movie movie = movies.getObject(m);
        if (customer != null && movie != null){
            customer.putMovie(movie, r);
            movie.add(customer);
        }
    }
}
