public class Citizen implements Person {
    private String name;
    private Integer age;

    public Citizen(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }
}
