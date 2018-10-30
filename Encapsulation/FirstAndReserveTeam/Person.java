
class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
          setFirstName(firstName);
          setLastName(lastName);
          setAge(age);
          setSalary(salary);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setFirstName(String firstName){
        if(firstName.length()<3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        if(lastName.length()<3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName=lastName;
    }
    public void setSalary(double salary){
        if(salary<460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }
    public void setAge(int age){
        if(age<=0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age=age;
    }

    public void increaseSalary(double bonus) {
        if (this.age < 30) {
            salary += (salary * bonus * 0.01)/2;
        } else {
            salary += salary * bonus * 0.01;
        }
    }

    public String toString() {
        return this.firstName+" "+this.lastName+" gets "+salary+" leva";
    }
}

