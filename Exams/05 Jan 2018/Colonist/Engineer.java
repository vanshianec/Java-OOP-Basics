package Colonist;

public abstract class Engineer extends Colonist {
    public Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);

    }

    public abstract int getPotential();

}
