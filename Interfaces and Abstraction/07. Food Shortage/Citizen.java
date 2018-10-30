public class Citizen implements Buyer {
    private String name;
    private Integer age;
    private String id;
    private String birthDate;
    private int food;

    public Citizen(String name, Integer age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        food = 0;
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

    public String getBirthDate() {
        return this.birthDate;
    }

    public int getFood(){
        return this.food;
    }

    public void buyFood(){
        this.food+=10;
    }
}
