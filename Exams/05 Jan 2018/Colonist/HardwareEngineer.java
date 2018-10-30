package Colonist;

public class HardwareEngineer extends Engineer {
    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);

    }

    @Override
    public int getPotential() {
        if(this.getAge()>30){
            setClassBonus(5);
        }
        else{
            setClassBonus(3);
        }
        if(this.getAge()<18){
            setAgeBonus(2);
        }
        else{
            setAgeBonus(0);
        }

        return this.getTalent()+this.getAgeBonus()+this.getClassBonus();
    }
}
