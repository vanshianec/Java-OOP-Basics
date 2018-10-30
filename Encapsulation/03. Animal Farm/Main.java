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
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        Chicken chicken;
        try{
            chicken=new Chicken(name,age);
            DecimalFormat format = new DecimalFormat("0.##");
            System.out.printf("Chicken %s (age %d) can produce %s eggs per day.%n"
                    ,chicken.getName(),chicken.getAge(),format.format(chicken.getEggsPerDay()));
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }




    }
}

class Chicken{
    private String name;
    private int age;

    public Chicken(String name,int age){
         setName(name);
         setAge(age);
    }

    private void setName(String name){
        if(name.length() == 0 || name.split(" ").length==0){
           throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    private void setAge(int age){
        if(age<0||age>15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age=age;
    }
    public double getEggsPerDay(){
        if(age>=0&&age<=5){
            return 2;
        }
        else if(age>=6&&age<=11){
            return 1;
        }
        return 0.75;
    }

}













