package Colonist;

public abstract class Colonist {
    private String id;
    private String familyId;
    private int talent;
    private int age;
    private int classBonus;
    private int ageBonus;

    public Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getFamilyId() {
        return familyId;
    }

    protected void setClassBonus(int classBonus) {
        this.classBonus = classBonus;
    }

    protected void setAgeBonus(int ageBonus) {
        this.ageBonus = ageBonus;
    }

    public int getClassBonus() {

        return classBonus;
    }

    public int getAgeBonus() {
        return ageBonus;
    }

    public int getTalent() {
        return talent;
    }

    public int getAge() {
        return age;
    }

    public abstract int getPotential();


	public void grow(int years){
       this.age += years;
    }



}
