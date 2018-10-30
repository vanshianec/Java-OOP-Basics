public class Spy extends Soldier implements ISpy {
    private Integer codeNumber;

    public Spy(String firstName, String lastName, Integer id, Integer codeNumber) {
        super(firstName, lastName, id);
        setCodeNumber(codeNumber);
    }

    @Override
    public Integer getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public void setCodeNumber(Integer codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String toString() {
        return String.format("Name: %s %s Id: %d%nCode Number: %s", getFirstName(), getLastName(), getId(), getCodeNumber());
    }
}
