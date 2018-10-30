package Colonist;

public abstract class Medic extends Colonist{
    private String sign;
    public Medic(String id, String familyId, int talent, int age,String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
        setClassBonus(2);
    }
    public abstract int getPotential();

    public String getSign() {
        return sign;
    }
}
