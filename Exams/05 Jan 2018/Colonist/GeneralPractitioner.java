package Colonist;

public class GeneralPractitioner extends Medic {
    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);

    }

    @Override
    public int getPotential() {
        if(this.getAge()>15){
            setAgeBonus(1);
        }
        else{
            setAgeBonus(0);
        }
        if(this.getSign().equals("caring")){
            setClassBonus(3);
        }
        else if (this.getSign().equals("careless")){
            setClassBonus(0);
        }
        return this.getTalent() + this.getAgeBonus() + this.getClassBonus();
    }
}
