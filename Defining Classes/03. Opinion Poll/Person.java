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
       int N = Integer.parseInt(reader.readLine());
       List<Person> persons = new ArrayList<>();
       while(N-->0){
           String input = reader.readLine();
           String name = input.split(" ")[0];
           int age = Integer.parseInt(input.split(" ")[1]);
           Person person = new Person(name,age);
           persons.add(person);
       }
       persons.stream().filter(p -> p.getAge()>30).sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
               .forEach(p -> System.out.printf("%s - %d%n",p.getName(),p.getAge()));
    }
}

class Person{
    private int age;
    private String name;

    public Person(){
        this("No name",1);
    }
    public Person(int age){
        this("No name",age);
    }
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age=age;
    }

}







