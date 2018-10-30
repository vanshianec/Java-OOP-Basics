public class Citizen {
    private String name;
    private Integer age;
    private String id;

    public Citizen(String name, Integer age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getId() {
        return id;
    }
}
