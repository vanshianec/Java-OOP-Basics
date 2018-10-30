package Colonist;

public class Surgeon extends Medic {
    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);

    }

    @Override
    public int getPotential() {
        if (this.getAge() > 25 && this.getAge() < 35) {
            this.setAgeBonus(2);
        }
        else{
            this.setAgeBonus(0);
        }
        if(this.getSign().equals("precise")){
            setClassBonus(5);
        }
        else if(this.getSign().equals("butcher")){
            setClassBonus(-1);
        }
        return this.getTalent() + this.getClassBonus() + this.getAgeBonus();
    }
}
