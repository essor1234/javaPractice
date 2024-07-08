import java.util.ArrayList;
import java.util.EmptyStackException;

public class OrderQueue {
    private final ArrayList<String> orders = new ArrayList<>();

    public void enqueue(String order){
        this.orders.add(order);
    }
    
    public boolean is_empty(){
        return orders.isEmpty();
    }

    public String dequeue(){
        if(is_empty()){
            throw new EmptyStackException();
        }
        return this.orders.removeFirst();
    }

    public int size(){
        return this.orders.size();
    }
}
