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
        HashMap<String, List<Employee>> departments = new HashMap<>();
        while (N-- > 0) {
            String input = reader.readLine();
            String[] tokens = input.split(" ");
            Employee employee;
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
                if (!departments.containsKey(department)) {
                    departments.put(department, new ArrayList<>());
                }
                departments.get(department).add(employee);
            } else if (tokens.length == 5) {
                try {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                    if (!departments.containsKey(department)) {
                        departments.put(department, new ArrayList<>());
                    }
                    departments.get(department).add(employee);
                } catch (Exception e) {
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                    if (!departments.containsKey(department)) {
                        departments.put(department, new ArrayList<>());
                    }
                    departments.get(department).add(employee);
                }
            }
            else if (tokens.length == 4){
                employee= new Employee(name,salary,position,department);
                if (!departments.containsKey(department)) {
                    departments.put(department, new ArrayList<>());
                }
                departments.get(department).add(employee);
            }

        }
        String bestDepartment =departments.entrySet().stream().max((kv1,kv2) ->
                Double.compare(kv1.getValue().stream().mapToDouble(e1 -> e1.getSalary()).average().getAsDouble(),
                        kv2.getValue().stream().mapToDouble(e2 -> e2.getSalary()).average().getAsDouble()))
                .get().getKey();
        System.out.printf("Highest Average Salary: %s%n",bestDepartment);
        departments.get(bestDepartment).stream().sorted((e2,e1) -> Double.compare(e1.getSalary(),e2.getSalary()))
                .forEach(e -> System.out.printf("%s %.2f %s %d%n",e.getName(),e.getSalary(),e.getEmail(),e.getAge()));
    }
}

class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getPosition() {
        return this.position;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getEmail() {
        return this.email;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return String.format("%s %.2f %s %d%n", name, salary, email, age);
    }


}







