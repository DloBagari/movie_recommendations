import java.util.*;
public class MovieRecommenderTester{
    public static void main(String[] args){
        Movies movies  = new Movies("movies.txt");
        Customers customers = new Customers("customers.txt");
        Rates rates = new Rates("ratings.txt", movies, customers);
        Recommender recommender =  new Recommender(movies, customers);
        Collection<Customer> customersList = customers.values();
        Collection<Movie> moviesList = movies.values();
        for (Customer c: customersList){
            recommender.recommend(c);
        }
        
     }
}
