import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

class Programming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        List<Animal> animals = new ArrayList<>();
        while(!input.equals("End")){
            String foodInfo[] = reader.readLine().split(" ");
            String [] animalInfo = input.split(" ");
            String animalType = animalInfo[0];
            String animalName = animalInfo[1];
            double animalWeight = Double.parseDouble(animalInfo[2]);
            String livingRegion  = animalInfo[3];
            Animal animal = null;
            String foodType = foodInfo[0];
            int foodQuantity = Integer.parseInt(foodInfo[1]);
            Food food = null;
            switch (foodType){
                case "Vegetable":
                    food = new Vegetable(foodQuantity);
                    break;
                case "Meat":
                    food = new Meat(foodQuantity);
                    break;
            }
            try{
                switch(animalType){
                    case "Cat":
                        String breed = animalInfo[4];
                        animal = new Cat(animalName,animalType,animalWeight,livingRegion,breed);
                        animal.makeSound();
                        animal.eat(food);
                        break;
                    case "Tiger":
                        animal = new Tiger(animalName,animalType,animalWeight,livingRegion);
                        animal.makeSound();
                        animal.eat(food);
                        break;
                    case "Zebra":
                        animal = new Zebra(animalName,animalType,animalWeight,livingRegion);
                        animal.makeSound();
                        animal.eat(food);
                        break;
                    case "Mouse":
                        animal = new Mouse(animalName,animalType,animalWeight,livingRegion);
                        animal.makeSound();
                        animal.eat(food);
                        break;
                }
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            if(animal!=null){
               animals.add(animal);
            }
            input = reader.readLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }

    }
}

abstract class Food{
    private int quantity;

    protected Food(int quantity){
        setQuantity(quantity);
    }
    private void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public int getQuantity(){
        return this.quantity;
    }
}

class Vegetable extends Food{

    protected Vegetable(int quantity){
        super(quantity);
    }
}

class Meat extends Food{

    protected Meat(int quantity){
        super(quantity);
    }
}


abstract class Animal{
        private String animalName;
        private String animalType;
        private double animalWeight;
        private int foodEaten;

        protected Animal(String animalName,String animalType,double animalWeight){
            setAnimalName(animalName);
            setAnimalType(animalType);
            setAnimalWeight(animalWeight);
        }
        protected void setAnimalName(String animalName){
            this.animalName= animalName;
        }
        protected void setAnimalType(String animalType){
            this.animalType = animalType;
        }
        protected void setAnimalWeight(double animalWeight){
            this.animalWeight = animalWeight;
        }
        protected void setFoodEaten(int foodEaten){
            this.foodEaten = foodEaten;
        }
        public String getAnimalName(){
            return this.animalName;
        }
        public String getAnimalType(){
            return this.animalType;
        }
        public double getAnimalWeight(){
            return this.animalWeight;
        }
        public int getFoodEaten(){
            return this.foodEaten;
        }

        public abstract  void makeSound();
        public abstract  void eat(Food food);

}

abstract class Mammal extends Animal{
    private String livingRegion;
    protected Mammal(String animalName,String animalType,double animalWeight,String livingRegion){
        super(animalName,animalType,animalWeight);
        setLivingRegion(livingRegion);
    }
    protected void setLivingRegion(String livingRegion){
        this.livingRegion = livingRegion;
    }
    public String getLivingRegion(){
        return this.livingRegion;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.##");
        sb.append(this.getClass().getSimpleName())
                .append("[").append(getAnimalName()).append(", ")
                .append(df.format(getAnimalWeight())).append(", ")
                .append(getLivingRegion()).append(", ")
                .append(getFoodEaten()).append("]");
        return sb.toString();
    }
}

class Mouse extends Mammal{
    protected Mouse(String animalName,String animalType,double animalWeight,String livingRegion){
        super(animalName,animalType,animalWeight,livingRegion);
    }
    public void makeSound(){
        System.out.println("SQUEEEAAAK!");
    }
    public void eat(Food food){
        if(food.getClass().getSimpleName().equals("Vegetable")){
            setFoodEaten(getFoodEaten()+food.getQuantity());
        }
        else{
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }

    }

}
class Zebra extends Mammal{
    protected Zebra(String animalName,String animalType,double animalWeight,String livingRegion){
        super(animalName,animalType,animalWeight,livingRegion);
    }
    public void makeSound(){
        System.out.println("Zs");
    }
    public void eat(Food food){
        if(food.getClass().getSimpleName().equals("Vegetable")){
            setFoodEaten(getFoodEaten()+food.getQuantity());
        }
        else{
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }

    }

}
abstract class Felime extends Mammal{

    protected Felime(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }
}
class Cat extends Felime{
     private String breed;

     protected Cat(String animalName,String animalType,double animalWeight,String livingRegion,String breed){
         super(animalName,animalType,animalWeight,livingRegion);
         setBreed(breed);
     }
     public String getBreed(){
         return this.breed;
     }
     protected void setBreed(String breed){
         this.breed = breed;
     }

    public void makeSound(){
        System.out.println("Meowwww");
    }
    public void eat(Food food){
        if(food.getClass().getSimpleName().equals("Vegetable")||food.getClass().getSimpleName().equals("Meat")){
            setFoodEaten(getFoodEaten()+food.getQuantity());
        }
        else{
            throw new IllegalArgumentException("Cats are not eating that type of food!");
        }

    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.##");
        sb.append(this.getClass().getSimpleName())
                .append("[").append(getAnimalName()).append(", ")
                .append(getBreed()).append(", ")
                .append(df.format(getAnimalWeight())).append(", ")
                .append(getLivingRegion()).append(", ")
                .append(getFoodEaten()).append("]");
        return sb.toString();
    }

}
class Tiger extends Felime{

    protected Tiger(String animalName,String animalType,double animalWeight,String livingRegion){
        super(animalName,animalType,animalWeight,livingRegion);
    }
    public void makeSound(){
        System.out.println("ROAAR!!!");
    }
    public void eat(Food food){
        if(food.getClass().getSimpleName().equals("Meat")){
            setFoodEaten(getFoodEaten()+food.getQuantity());
        }
        else{
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }

    }


}
//bad practice just for testing purpose