public class Mission implements  IMission{
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.state = state;
    }

    public String getCodeName() {
        return codeName;
    }

    public String getState() {
        return state;
    }

    @Override
    public void completeMission() {
        state = "Finished";
    }

    public String toString(){
        return String.format("Code Name: %s State: %s",getCodeName(),getState());
    }
}
