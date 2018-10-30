import java.util.HashSet;
import java.util.Set;

public class Commando extends SpecialisedSoldier{
   private Set<Mission> missions;

   public Commando(String firstName, String lastName, Integer id, Double salary, String corps) {
      super(firstName, lastName, id, salary, corps);
      missions = new HashSet<>();
   }
   public void addMission(Mission mission){
      missions.add(mission);
   }
   public String toString(){
      StringBuilder str = new StringBuilder();
      String output = "";
      str.append(System.lineSeparator());
      for (Mission mission : missions) {
         str.append(" ").append(" ").append(mission).append(System.lineSeparator());
      }
      if(str.toString().split("\\s+").length!=0){
        output = str.toString().substring(0,str.toString().lastIndexOf(System.lineSeparator()));
      }
      return String.format("Name: %s %s Id: %d Salary: %.2f%nCorps: %s%nMissions:%s",
              getFirstName(),getLastName(),getId(),getSalary(),getCorps(),output);
   }
}
