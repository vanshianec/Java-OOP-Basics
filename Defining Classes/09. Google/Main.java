import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Programming {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String,Person> persons = new LinkedHashMap<>();
        String input =reader.readLine();
        while(!input.equals("End")){
            String name = input.split(" ")[0];
            String type = input.split(" ")[1];
            if(!persons.containsKey(name)){
                persons.put(name,new Person(name));
            }
            switch(type){
                case "company":
                    String companyName = input.split(" ")[2];
                    String department = input.split(" ")[3];
                    double salary = Double.parseDouble(input.split(" ")[4]);
                    Company company = new Company(companyName,department,salary);
                    persons.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = input.split(" ")[2];
                    String pokemonType = input.split(" ")[3];
                    Pokemon pokemon = new Pokemon(pokemonName,pokemonType);
                    persons.get(name).addPokemon(pokemon);
                    break;
                case "parents":
                    String parentName = input.split(" ")[2];
                    String parentBirthday = input.split(" ")[3];
                    Parent parent = new Parent(parentName,parentBirthday);
                    persons.get(name).addParent(parent);
                    break;
                case "children":
                    String childName = input.split(" ")[2];
                    String childBirthday = input.split(" ")[3];
                    Child child = new Child(childName,childBirthday);
                    persons.get(name).addChild(child);
                    break;
                case "car":
                    String carModel = input.split(" ")[2];
                    int carSpeed  = Integer.parseInt(input.split(" ")[3]);
                    Car car = new Car(carModel,carSpeed);
                    persons.get(name).setCar(car);
                    break;
            }


            input = reader.readLine();
        }
        String chosenPerson = reader.readLine();
        if(persons.containsKey(chosenPerson)){
            System.out.println(persons.get(chosenPerson));

        }

    }
}

class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;

    public Person(String name) {
        this.name = name;
        pokemons=new ArrayList<>();
        parents = new ArrayList<>();
        children = new ArrayList<>();
    }

    public void setCompany(Company company){
        this.company=company;
    }
    public void setCar(Car car){
        this.car = car;
    }
    public void addPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }
    public void addParent(Parent parent){
        parents.add(parent);
    }
    public void addChild(Child child){
        children.add(child);
    }

    public String getPokemons(){
        StringBuilder allPokemons = new StringBuilder();
        for (Pokemon pokemon : pokemons) {
            allPokemons.append(pokemon);
            allPokemons.append("\n");
        }
        return allPokemons.toString();
    }
    public String getParents(){
        StringBuilder allParents= new StringBuilder();
        for (Parent parent : parents) {
            allParents.append(parent);
            allParents.append("\n");
        }
        return allParents.toString();
    }
    public String getChildren(){
        StringBuilder allChildren= new StringBuilder();
        for (Child child : children) {
            allChildren.append(child);
            allChildren.append("\n");
        }
        return allChildren.toString();
    }

    public String toString(){
        return String.format("%s%nCompany:%n%s%nCar:%n%s%nPokemon:%n%sParents:%n%sChildren:%n%s%n",
                name,company,car,getPokemons(),getParents(),getChildren()).replaceAll("null\r\n","");
    }




}
class Company {
    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public String toString(){
        return String.format("%s %s %.2f",name,department,salary);
    }
}

class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public String toString(){
        return String.format("%s %s",name,type);
    }
}

class Parent {
    private String name;
    private String birthday;

    public Parent(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    public String toString(){
        return String.format("%s %s",name,birthday);
    }
}

class Child {
    private String name;
    private String birthday;

    public Child(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    public String toString(){
        return String.format("%s %s",name,birthday);
    }
}

class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }
    public String toString(){
        return String.format("%s %d",model,speed);
    }
}
//bad practice just for testing purpose










