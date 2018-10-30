import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Programming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] tokens = reader.readLine().split(" ");
        Gandalf gandalf = new Gandalf();
        for (String foodName : tokens) {
            Food food = new Food(foodName);
            gandalf.addFood(food);
        }
        System.out.println(gandalf.getTotalHappiness());
        System.out.println(gandalf.getMood());

    }
}

class Gandalf {
    private List<Food> foodList;

    public Gandalf(){
        foodList= new ArrayList<>();
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public int getTotalHappiness() {
        int temp = 0;
        for (Food food : foodList) {
            temp += food.getHappiness();
        }
        return temp;
    }

    public String getMood() {
        int totalHappiness = this.getTotalHappiness();
        if (totalHappiness < -5) {
            return "Angry";
        } else if (totalHappiness >= -5 && totalHappiness < 0) {
            return "Sad";
        } else if (totalHappiness>0 && totalHappiness<=15){
            return "Happy";
        }
        return "JavaScript";
    }

}

class Food {
    private String name;
    private int happiness;

    public Food(String name) {
        this.setName(name);
    }

    protected void setName(String name) {
        switch (name.toLowerCase()) {
            case "cram":
                this.name = name;
                this.happiness = 2;
                break;
            case "lembas":
                this.name = name;
                this.happiness = 3;
                break;
            case "apple":
                this.name = name;
                this.happiness = 1;
                break;
            case "melon":
                this.name = name;
                this.happiness = 1;
                break;
            case "honeycake":
                this.name = name;
                this.happiness = 5;
                break;
            case "mushrooms":
                this.name = name;
                this.happiness = -10;
                break;
            default:
                this.name = name;
                this.happiness = -1;
                break;
        }
    }

    protected int getHappiness() {
        return this.happiness;
    }
}

//bad practice just for testing purpose











