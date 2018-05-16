import java.util.*;

public abstract class BuildStructure<T>{
    protected Read_File file;
    protected Iterator<String[]> iter;
    protected Map<Integer, T> structure;
    public BuildStructure(String filename){
        file = new Read_File(filename);
        iter = file.iterator();
        structure = new HashMap<>();
        while (iter.hasNext()){
            String[] details = iter.next();
            int id = Integer.parseInt(details[0]);
             T obj = makeObject(id, details[1]);
             structure.put(id, obj);
        }
    }
    
    protected abstract T makeObject(int id, String name);
 
    public T getObject(int id){
        return structure.get(id);
    }
    
    public Collection<T> values(){
        return structure.values();
    }
}

        
   
