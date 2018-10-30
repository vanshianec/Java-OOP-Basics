import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private Random random;

    public RandomArrayList(){
       random = new Random();
    }

    public Object getRandomElement(){
        int index = random.nextInt(super.size());
        return super.get(index);
    }


}
