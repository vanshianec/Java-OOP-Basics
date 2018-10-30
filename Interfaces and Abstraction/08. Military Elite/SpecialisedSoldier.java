public abstract class SpecialisedSoldier extends Private implements ISpecialisedSoldier{
    private String corps;

    public SpecialisedSoldier(String firstName, String lastName, Integer id, Double salary,String corps) {
        super(firstName, lastName, id, salary);
        this.setCorps(corps);
    }

    public String getCorps(){
        return this.corps;
    }

    public void setCorps(String corps){
        this.corps = corps;
    }
}
