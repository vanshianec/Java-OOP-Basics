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
        List<String> persons = Arrays.stream(reader.readLine().split(";")).collect(Collectors.toList());
        List<String> products = Arrays.stream(reader.readLine().split(";")).collect(Collectors.toList());
        List<Person> people = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        for (String person : persons) {
            Person p;
            try{
                p = new Person(person.split("=")[0],Double.parseDouble(person.split("=")[1]));
                people.add(p);
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }

        }
        for (String product : products) {
            Product p;
            try{
             p = new Product(product.split("=")[0],Double.parseDouble(product.split("=")[1]));
                productList.add(p);
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }
        String command = reader.readLine();
        while(!command.equals("END")){
            String personName= command.split(" ")[0];
            String productName= command.split(" ")[1];
            for (Person person : people) {
                if(person.getName().equals(personName)){
                    for (Product product : productList) {
                        if(product.getName().equals(productName)){
                            person.addProduct(product);
                            break;
                        }
                    }
                }
            }

            command=reader.readLine();
        }
        for (Person person : people) {
            System.out.println(person);
        }




    }
}

class Person{
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name,double money){
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }
    public String getName(){
        return this.name;
    }

    private void setName(String name){
        if(name.length()==0 || name.split(" ").length==0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name=name;
    }
    private void setMoney(double money){
        if(money<0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money=money;
    }
    public void addProduct(Product product){
        if(this.money<product.price){
            System.out.printf("%s can't afford %s%n",this.name,product.name);
        }
        else{
            System.out.printf("%s bought %s%n",this.name,product.name);
            this.money-=product.price;
            products.add(product);
        }
    }
    public String toString(){
        String output = this.name + " - ";
        if(products.isEmpty()){
            output=output.concat("Nothing bought");
        }
        else{
           List<String> productsNames = new ArrayList<>();
            for (Product product : products) {
                productsNames.add(product.name);
            }
           output= output.concat(String.join(", ",productsNames));
        }
        return output;
    }

}

class Product{
    String name;
    double price;

    public Product(String name,double money){
        setName(name);
        setMoney(money);
    }

    private void setName(String name){
        if(name.length()==0 || name.split(" ").length==0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    private void setMoney(double price){
        if(price<0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.price=price;
    }
}
//bad practice just for testing purpose














