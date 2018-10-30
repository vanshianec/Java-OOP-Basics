public class Citizen implements Person,Identifiable,Birthable{
    private String name;
    private Integer age;
    private String birthday;
    private String id;

    public Citizen(String name, Integer age,String id,String birthday) {
        this.age = age;
        this.name = name;
        this.id = id;
        this.birthday = birthday;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
