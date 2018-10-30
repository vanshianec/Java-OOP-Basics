import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Programming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        try{
            Child child = new Child(name,age);
            System.out.println(child);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    protected void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    public String toString(){
        return String.format("Name: %s, Age: %d",this.getName(),this.getAge());
    }

}
class Child extends Person {
    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    protected void setAge(int age) {
        if (age >= 15) {
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
        super.setAge(age);
    }
}
//bad practice just for testing purpose









