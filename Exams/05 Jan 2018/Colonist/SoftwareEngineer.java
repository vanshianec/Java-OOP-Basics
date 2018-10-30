package Colonist;

public class SoftwareEngineer extends Engineer{
    public SoftwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
        setAgeBonus(2);
    }

    @Override
    public int getPotential() {
        if(this.getAge()>30){
            setClassBonus(5);
        }
        else{
            setClassBonus(3);
        }
        return this.getTalent()+this.getAgeBonus()+this.getClassBonus();
    }
}
