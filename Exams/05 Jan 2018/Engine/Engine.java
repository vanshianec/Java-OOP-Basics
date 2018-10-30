package Engine;
import Family.Family;
import IO.ConsoleInputReader;
import IO.ConsoleOutputWriter;
import Utilities.InputParser;
import Colonist.Colonist;
import Colonist.GeneralPractitioner;
import Colonist.Soldier;
import Colonist.SoftwareEngineer;
import Colonist.Surgeon;
import Colonist.HardwareEngineer;

import java.util.List;
import Colony.Colony;

public class Engine {
    private static final String END_COMMAND = "end";
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private Colony colony;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser,Colony colony) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.colony = colony;
    }

    public void run() {
        String inputLine;

        while(true) {
            inputLine = this.inputReader.readLine();
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);
            if (inputLine.equals(END_COMMAND)) {
                break;
            }
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);
        Colonist colonist = null;
        String familyId = "";
        String colonistId = "";
        switch(command) {
            case"insert":
                String classType = commandParams.get(0);
                colonistId = commandParams.get(1);
                familyId = commandParams.get(2);
                int talent = Integer.parseInt(commandParams.get(3));
                int age = Integer.parseInt(commandParams.get(4));
                String sign = "";
                switch(classType){
                    case"GeneralPractitioner":
                        sign = commandParams.get(5);
                        colonist = new GeneralPractitioner(colonistId,familyId,talent,age,sign);
                        break;
                    case"Surgeon":
                        sign = commandParams.get(5);
                        colonist = new Surgeon(colonistId,familyId,talent,age,sign);
                        break;
                    case "SoftwareEngineer":
                        colonist = new SoftwareEngineer(colonistId,familyId,talent,age);
                        break;
                    case "HardwareEngineer":
                        colonist = new HardwareEngineer(colonistId,familyId,talent,age);
                        break;
                    case "Soldier":
                        colonist = new Soldier(colonistId,familyId,talent,age);
                        break;
                }
                if(this.colony.ContainsFamily(familyId)){
                    this.colony.addColonist(colonist);
                }
                else{
                    try{
                    this.colony.addFamily(new Family(familyId));
                    this.colony.addColonist(colonist);
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
            case "remove":
                String modificator = commandParams.get(0);
                familyId = commandParams.get(1);
                colonistId = "";
                switch(modificator){
                    case "family":
                        this.colony.removeFamily(familyId);
                        break;
                    case"colonist":
                        colonistId = commandParams.get(2);
                        this.colony.removeColonist(familyId,colonistId);
                        break;
                }
                break;
            case "grow":
                int years = Integer.parseInt(commandParams.get(0));
                this.colony.grow(years);
                break;
            case "potential":
                this.outputWriter.writeLine("potential: "+this.colony.getPotential());
                break;
            case "capacity":
                this.outputWriter.writeLine(this.colony.getCapacity());
                break;
            case "family":
                familyId = commandParams.get(0);
                this.outputWriter.writeLine(this.colony.getColonists(familyId));
                break;
        }
    }
}