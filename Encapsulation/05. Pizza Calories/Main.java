import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Programming {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pizzaStats[] = reader.readLine().split(" ");
        String pizzaName = pizzaStats[1];
        int numberOfToppings = Integer.parseInt(pizzaStats[2]);
        Pizza pizza;
        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        String doughStats[] = reader.readLine().split(" ");
        String flourType = doughStats[1];
        String bakingTechnique = doughStats[2];
        int weight = Integer.parseInt(doughStats[3]);
        Dough dough;
        try{
            dough = new Dough(flourType,bakingTechnique,weight);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        pizza.setDough(dough);
        while(numberOfToppings -- > 0){
            String toppingStats[] = reader.readLine().split(" ");
            String toppingType = toppingStats[1];
            int toppingWeight = Integer.parseInt(toppingStats[2]);
            Topping topping;
            try{
                topping = new Topping(toppingType,toppingWeight);
                pizza.addTopping(topping);
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.printf("%s - %.2f%n",pizza.getName(),pizza.getCalories());

    }
}

class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setNumberOfToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }


    private void setName(String name) {
        if (name.length() < 1 || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getCalories() {
        double totalCalories = 0;
        for (Topping topping : toppings) {
            totalCalories += topping.getCalories();
        }
        return totalCalories+dough.getCalories();
    }
    public String getName(){
        return this.name;
    }


}

class Dough {
    private String flourType;
    private String bakingTechnique;
    private int weight;

    public Dough(String flourType, String bakingTechnique, int weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("Wholegrain") || flourType.equals("White")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(int weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double getCalories() {
        double flourModifier = 0;
        double techniqueModifier = 0;
        switch (flourType) {
            case "White":
                flourModifier = 1.5;
                break;
            case "Wholegrain":
                flourModifier = 1.0;
                break;
        }
        switch (bakingTechnique) {
            case "Crispy":
                techniqueModifier = 0.9;
                break;
            case "Chewy":
                techniqueModifier = 1.1;
                break;
            case "Homemade":
                techniqueModifier = 1.0;
                break;
        }
        return (2 * weight) * flourModifier * techniqueModifier;
    }


}

class Topping {
    private String toppingType;
    private int weight;

    public Topping(String toppingType, int weight) {
          setToppingType(toppingType);
          setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") || toppingType.equals("Cheese") || toppingType.equals("Sauce") || toppingType.equals("Veggies")) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }

    }

    private void setWeight(int weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double getCalories() {
        double modifier = 0;
        switch (toppingType) {
            case "Meat":
                modifier = 1.2;
                break;
            case "Veggies":
                modifier = 0.8;
                break;
            case "Cheese":
                modifier = 1.1;
                break;
            case "Sauce":
                modifier = 0.9;
                break;
        }
        return (2 * weight) * modifier;
    }
}

//bad practice just for testing purpose














