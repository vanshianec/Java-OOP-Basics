public class Citizen {
    private String name;
    private Integer age;
    private String id;
    private String birthDate;

    public Citizen(String name, Integer age, String id,String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
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

    public String getBirthDate(){
        return this.birthDate;
    }
}
