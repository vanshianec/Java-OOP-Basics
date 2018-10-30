import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings(){
        this.data = new ArrayList<>();
    }

    public void push(String item){
        this.data.add(item);
    }
    public String pop() throws Exception {
        if(!data.isEmpty()){
        return this.data.remove(data.size()-1);
        }
        throw new Exception("The stack is empty");
    }
    public String peek() throws Exception {
        if(!data.isEmpty()){
            return this.data.get(data.size()-1);
        }
        throw new Exception("The stack is empty");
    }
    public boolean isEmpty(){
        return this.data.isEmpty();
    }

}
