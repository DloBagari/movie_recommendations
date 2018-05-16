import java.util.*;
public class Movies extends BuildStructure<Movie>{
    
    public Movies(String filename){
        super(filename);
    }
    
    protected Movie makeObject(int id, String name){
        Movie  m = new Movie (id, name);
        return m;
    }

}//end Movies class
