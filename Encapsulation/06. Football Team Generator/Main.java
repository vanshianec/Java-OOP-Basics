import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Programming {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        List<Team> teams = new ArrayList<>();
        while(!command.equals("END")){
            Team team;
            if(command.contains("Team")){
                String name = command.split(";")[1];
                try{
                    team = new Team(name);
                    teams.add(team);
                }
                catch(Exception e ){
                    System.out.println(e.getMessage());
                }
            }
            else if (command.contains("Add")){
                String teamName = command.split(";")[1];
                String playerName = command.split(";")[2];
                double endurance = Double.parseDouble(command.split(";")[3]);
                double sprint = Double.parseDouble(command.split(";")[4]);
                double dribble = Double.parseDouble(command.split(";")[5]);
                double passing = Double.parseDouble(command.split(";")[6]);
                double shooting = Double.parseDouble(command.split(";")[7]);
                boolean exist=false;
                Player player;
                for (Team t : teams) {
                    if(t.getName().equals(teamName)){
                        exist=true;
                        try{
                            player = new Player(playerName,endurance,sprint,dribble,passing,shooting);
                            t.addPlayer(player);
                        }
                        catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                }
                if(!exist){
                    System.out.println("Team "+teamName+" does not exist.");
                }
            }
            else if (command.contains("Remove")){
                String teamName = command.split(";")[1];
                String playerName = command.split(";")[2];
                Player player;
                boolean exist=false;
                for (Team t : teams) {
                    if(t.getName().equals(teamName)){
                        exist=true;
                        try{
                           t.removePlayer(playerName);
                        }
                        catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                }
                if(!exist){
                    System.out.println("Team "+teamName+" does not exist.");
                }
            }
            else if (command.contains("Rating")){
                String teamName = command.split(";")[1];
                boolean exist=false;
                for (Team t : teams) {
                    if(t.getName().equals(teamName)){
                        exist=true;
                        System.out.println(teamName+" - "+(int)Math.rint(t.getAverageRating()));
                        break;
                    }
                }
                if(!exist){
                    System.out.println("Team "+teamName+" does not exist.");
                }
            }


            command= reader.readLine();
        }
    }
}

class Team{
    private String name;
    private List<Player> players;
    private int rating;

    public Team(String name){
       setName(name);
       players= new ArrayList<>();
    }
    private void setName(String name){
        if(name.length()==0 || name.split(" ").length==0){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    public void removePlayer(String playerName){
        boolean removed = players.removeIf(p -> p.getName().equals(playerName));
        if(!removed){
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.",playerName,this.name));
        }
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public double getAverageRating(){
        double average =0;
        for (Player player : players) {
            average+=player.getAverageRating();
        }
        return average/players.size();
    }


}

class Player{
    private String name;
    private double endurance;
    private double sprint;
    private double dribble;
    private double passing;
    private double shooting;

    public Player(String name,double endurance,double sprint,double dribble,double passing,double shooting){
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name){
        if(name.length()==0 || name.split(" ").length==0){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    private void setSprint(double sprint){
        if(sprint<0||sprint>100){
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint=sprint;
    }
    private void setDribble(double dribble){
        if(dribble<0||dribble>100){
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble=dribble;
    }
    private void setPassing(double passing){
        if(passing<0||passing>100){
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing=passing;
    }
    private void setEndurance(double endurance){
        if(endurance<0||endurance>100){
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance=endurance;
    }
    private void setShooting(double shooting){
        if(shooting<0||shooting>100){
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting=shooting;
    }

    public double getAverageRating(){
        return (shooting+sprint+endurance+dribble+passing)/5;
    }

}

//bad practice just for testing purpose














