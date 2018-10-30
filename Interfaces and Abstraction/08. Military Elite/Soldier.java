public abstract class Soldier implements ISoldier{
    private String firstName;
    private String lastName;
    private Integer id;

    public Soldier(String firstName,String lastName,Integer id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public Integer getId(){
        return this.id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setId(Integer id){
        this.id = id;
    }

}
