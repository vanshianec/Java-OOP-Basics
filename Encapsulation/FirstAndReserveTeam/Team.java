

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name){
        this.name = name;
        firstTeam = new ArrayList<>();
        reserveTeam = new ArrayList<>();
    }

    public void addPlayer(Person person){
        if(person.getAge()<40){
            firstTeam.add(person);
        }
        else{
            reserveTeam.add(person);
        }
    }
    public List<Person> getFirstTeam(){
        return Collections.unmodifiableList(firstTeam);
    }
    public List<Person> getReverseTeam(){
        return Collections.unmodifiableList(reserveTeam);
    }
}
