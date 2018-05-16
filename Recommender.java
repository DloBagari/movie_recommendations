import java.util.*;
public class Recommender implements Tools<Customer, Movie>{
    private Movies movies;
    private Customers customers;
    
    public Recommender( Movies movies, Customers customers){
        this.movies = movies;
        this.customers = customers;
    }
    
    public void recommend(Customer customer){
        List<Movie> notRated = difference( customer.getRated(),
                                              movies.values());
        if (notRated.size() != 0){
            double maxScore = 0.0;
            Movie recommended = notRated.get(0);
            for (Movie m: notRated){
                double s = score(customer, m);
                if ( s > maxScore){
                    maxScore = s;
                    recommended = m;
               }
            }
         System.out.printf("To customer %2d, I recommed id: %2d title: %s\n",
                           customer.getId(), recommended.getId(), recommended.getName());
        }
       
    }
    
    public List<Movie> difference( Collection<Movie> customerMovies,
                                         Collection<Movie> allMovies){
        List<Movie> notRated = new ArrayList<>();
        for( Movie m: allMovies){
            if (!customerMovies.contains(m)){
                notRated.add(m);
            }
        }
        return notRated;
    }

    public double score(Customer c, Movie m){
        Set<Customer> s = m.getRatedBy();
        double sumWeightRate = 0.0;
        double sumWeight = 0.0;
        for (Customer x: s){
            try{
                double w = weight(c, x);
                sumWeightRate += w * rate(x, m);
                sumWeight += w;
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return sumWeightRate / sumWeight;
    }
    
    public int rate( Customer c, Movie m)throws Exception{
        return c.get(m);
    } 

    public double weight(Customer c, Customer x){
        List<Movie> comman = commanMovies(c,x);
        double sumRate = 0.0;
        for (Movie m: comman){
            try{
                sumRate += Math.pow((rate(c, m) - rate(x, m)), 2);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        double result = 1/(1 + Math.sqrt(sumRate));
        return result; 
    }
    
    public List<Movie> commanMovies(Customer c, Customer x){
        List<Movie> comman = new ArrayList<>();
        Collection<Movie> xMovies = x.getRated();
        for(Movie m: c.getRated()){
            if (xMovies.contains(m)){
                comman.add(m);
            }
        }
        return comman;
    }
}// end class 









