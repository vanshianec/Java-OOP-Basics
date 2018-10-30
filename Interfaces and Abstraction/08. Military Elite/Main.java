import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        List<Private> privates = new ArrayList<>();
        List<Soldier> soldiers = new ArrayList<>();
        while (!input.equals("End")) {
            String tokens[] = input.split(" ");
            switch (tokens[0]) {
                case "Private":
                    privates.add(new Private(tokens[2], tokens[3], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[4])));
                    soldiers.add(new Private(tokens[2], tokens[3], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[4])));
                    break;
                case "LeutenantGeneral":
                    LeutenantGeneral leutenantGeneral = new LeutenantGeneral(tokens[2], tokens[3], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[4]));
                    for (int i = 5; i < tokens.length; i++) {
                        for (Private aPrivate : privates) {
                            if (aPrivate.getId().equals(Integer.parseInt(tokens[i]))) {
                               leutenantGeneral.addPrivate(aPrivate);
                            }
                        }
                    }
                    soldiers.add(leutenantGeneral);
                    break;
                case "Engineer":
                    if(tokens[5].equals("Airforces")||tokens[5].equals("Marines")){
                        Engineer engineer = new Engineer(tokens[2], tokens[3], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[4]), tokens[5]);
                        for (int i = 6; i < tokens.length - 1; i+=2) {
                            Repair repair = new Repair(tokens[i], Integer.parseInt(tokens[i + 1]));
                            engineer.addRepair(repair);
                        }
                        soldiers.add(engineer);
                    }
                    break;
                case "Commando":
                    Commando commando = new Commando(tokens[2], tokens[3], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[4]), tokens[5]);
                    for (int i = 6; i < tokens.length - 1; i+=2) {
                        if(tokens[i+1].equals("inProgress")||tokens[i+1].equals("Finished")){
                        Mission mission = new Mission(tokens[i], tokens[i + 1]);
                        commando.addMission(mission);
                        }
                    }
                    soldiers.add(commando);
                    break;
                case "Spy":
                    soldiers.add(new Spy(tokens[2], tokens[3], Integer.parseInt(tokens[1]),Integer.parseInt(tokens[4])));
                    break;
            }
        input = reader.readLine();

        }
        for (Soldier soldier : soldiers) {
            System.out.println(soldier);
        }

    }


}

