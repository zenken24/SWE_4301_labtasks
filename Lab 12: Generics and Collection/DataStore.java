
import java.util.*; 

//T lets you write the code only once, and then you can use it for any type. 
// Without it, you'd need a separate class for each type, like StudentStore, StringStore, etc. 
// But with generics, you can have one class that can store anything you want.
public class DataStore<T> {
    private List<T> items = new ArrayList<>();

    //adding each item
    public void add(T item){
        items.add(item);
    }

    //getting all 
    public List<T> getAll(){
        return items; 
    }

}
