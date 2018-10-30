
class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
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

