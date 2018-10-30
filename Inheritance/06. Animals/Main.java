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
        String input =reader.readLine();
        while(!input.equals("Beast!")){
            String info[] = reader.readLine().split(" ");
            String animal = input;
            String name = info[0];
            String age =info[1];
            String gender = info[2];
            Animal an;
            switch (animal){
                case "Animal":
                    try{
                        an=new Animal(name,age,gender);
                        System.out.println(an);
                    }
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Dog":
                    try{
                        an=new Dog(name,age,gender);
                        System.out.println(an);
                    }
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Cat":
                    try{
                        an=new Cat(name,age,gender);
                        System.out.println(an);
                    }
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Frog":
                    try{
                        an=new Frog(name,age,gender);
                        System.out.println(an);
                    }
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Kitten":
                    try{
                        an=new Kitten(name,age,gender);
                        System.out.println(an);
                    }
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Tomcat":
                    try{
                        an=new Tomcat(name,age,gender);
                        System.out.println(an);
                    }
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                    default:
                        try{
                            throw new IllegalArgumentException("Invalid input!");
                        }
                        catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }


            }
            input=reader.readLine();
        }

    }
}

class Animal{
    private String name;
    private String age;
    private String gender;

    public Animal(String name,String age,String gender){
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName(){
        return this.name;
    }
    public String getAge(){
        return this.age;
    }
    public String getGender(){
        return this.gender;
    }
    protected void setName(String name){
        if(name.length()==0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name=name;
    }
    protected void setAge(String age){
        try{
            Integer.parseInt(age);
        }
        catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid input!");
        }
        if(Integer.parseInt(age)<0||age.length()==0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age=age;
    }
    protected void setGender(String gender){
        if(gender.length()==0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender=gender;
    }
    public String produceSound(){
        return "Not implemented!";
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName())
                .append("\n").append(this.getName()).append(" ").append(this.getAge()).append(" ").append(this.getGender())
                .append("\n").append(this.produceSound());
        return sb.toString();
    }



}
class Frog extends Animal{
    public Frog(String name,String age,String gender){
        super(name,age,gender);
    }
    public String produceSound(){
        return "Frogggg";
    }
}

class Dog extends Animal{
    public Dog(String name,String age,String gender){
        super(name,age,gender);
    }
    public String produceSound(){
        return "BauBau";
    }
}

class Cat extends Animal{
    public Cat(String name,String age,String gender){
        super(name,age,gender);
    }
    public String produceSound(){
        return "MiauMiau";
    }
}
class Kitten extends Cat{
    public Kitten(String name,String age,String gender){
        super(name,age,gender);
    }
    public String produceSound(){
        return "Miau";
    }
}
class Tomcat extends  Cat{
    public Tomcat(String name,String age,String gender){
        super(name,age,gender);
    }
    public String produceSound(){
        return "Give me one million b***h";
    }
}

//bad practice just for testing purpose




