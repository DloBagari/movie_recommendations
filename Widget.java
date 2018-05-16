import java.util.*;
public abstract class Widget{
    
    protected int id;
    protected String name;
    /** construct An object */
    public Widget(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public int getId(){
       return id;
    }
    
    public String getName(){
        return name;
    }
    public String toString(){
        return this.id + " " + this.name;
    }
  
    public boolean equals(Object o){
       if (this == o){
            return true;
        }else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Movie m = (Movie) o;
        return (this.name.equals(m.getName()) && this.id == m.getId());
    }
   
}// end class Widget
