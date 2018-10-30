import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeutenantGeneral extends Private implements  ILeutenantGeneral{
    private Set<Private> privates;

    public LeutenantGeneral(String firstName, String lastName, Integer id, Double salary) {
        super(firstName, lastName, id, salary);
        privates = new HashSet<>();
    }


    @Override
    public void addPrivate(Private pri) {
        privates.add(pri);
    }
    public String toString(){

        StringBuilder str = new StringBuilder();
        String output = "";
        str.append(System.lineSeparator());
        this.privates.stream().sorted((p2,p1) -> p1.getId().compareTo(p2.getId())).forEach(p -> str.append(" ").append(" ").append(p).append(System.lineSeparator()));
        if(str.toString().split("\\s+").length!=0){
            output = str.toString().substring(0,str.toString().lastIndexOf(System.lineSeparator()));
        }
        return String.format("Name: %s %s Id: %d Salary: %.2f%nPrivates:%s",getFirstName(),getLastName(),getId(),getSalary(),output);
    }
}
