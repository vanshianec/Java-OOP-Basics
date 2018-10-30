public class Private extends Soldier implements IPrivate{
    private Double salary;

    public Private(String firstName, String lastName, Integer id,Double salary) {
        super(firstName, lastName, id);
        setSalary(salary);
    }


    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }

    public String toString(){
        return String.format("Name: %s %s Id: %d Salary: %.2f",getFirstName(),getLastName(),getId(),getSalary());
    }
}
