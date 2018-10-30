package Colonist;

public class Soldier extends Colonist{
    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
        setAgeBonus(3);
        setClassBonus(3);
    }

    @Override
    public int getPotential() {
       return this.getTalent() + this.getClassBonus() + this.getAgeBonus();
    }
}
