import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Programming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []studentInfo = reader.readLine().split(" ");
        String []workerInfo = reader.readLine().split(" ");
        try{
            Student st = new Student(studentInfo[0],studentInfo[1],Integer.parseInt(studentInfo[2]));
            Worker worker = new Worker(workerInfo[0],workerInfo[1],Double.parseDouble(workerInfo[2]),Integer.parseInt(workerInfo[3]));
            System.out.println(st);
            System.out.println(worker);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}

class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    protected void setFirstName(String firstName) {
        if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        } else if (!Character.isUpperCase(firstName.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        } else if (!Character.isUpperCase(lastName.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        this.lastName = lastName;
    }

    public String toString() {
        return String.format("First Name: %s%nLast Name: %s%n", this.getFirstName(), this.getLastName());
    }
}

class Student extends Human {
    int facNumber;

    public Student(String firstName, String lastName, int facNumber) {
        super(firstName, lastName);
        setFacNumber(facNumber);
    }

    public int getFacNumber() {
        return this.facNumber;
    }

    protected void setFacNumber(Integer facNumber) {
        if (facNumber.toString().length() < 5 || facNumber.toString().length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facNumber = facNumber;
    }

    public String toString() {
        return super.toString() + String.format("Faculty number: %d", this.getFacNumber());
    }

}

class Worker extends Human {
    private double weekSalary;
    private int workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, int workHoursPerDay) {
        super(firstName, lastName);

         setWeekSalary(weekSalary);
         setWorkHoursPerDay(workHoursPerDay);
    }

    public double getWeekSalary() {
        return this.weekSalary;
    }

    public int getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() <= 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    protected void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    protected void setWorkHoursPerDay(int workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }
    private double getSalaryPerHour(){
        return weekSalary/(workHoursPerDay*7);
    }

    public String toString(){
        return super.toString()+ String.format("Week Salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f",
                this.getWeekSalary(),(double)this.getWorkHoursPerDay(),this.getSalaryPerHour());
    }

}

//bad practice just for testing purpose







