import java.util.HashSet;
import java.util.Set;

public class Engineer extends SpecialisedSoldier {
   private Set<Repair> repairs;


    public Engineer(String firstName, String lastName, Integer id, Double salary, String corps) {
        super(firstName, lastName, id, salary, corps);
        repairs = new HashSet<>();
    }

    public void addRepair(Repair repair){
        repairs.add(repair);
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        String output = "";
        str.append(System.lineSeparator());
        for (Repair repair : repairs) {
            str.append(" ").append(" ").append(repair).append(System.lineSeparator());
        }
        if(str.toString().split("\\s+").length!=0){
            output = str.toString().substring(0,str.toString().lastIndexOf(System.lineSeparator()));
        }
        return String.format("Name: %s %s Id: %d Salary: %.2f%nCorps: %s%nRepairs:%s",
                getFirstName(),getLastName(),getId(),getSalary(),getCorps(),output);
    }
}
