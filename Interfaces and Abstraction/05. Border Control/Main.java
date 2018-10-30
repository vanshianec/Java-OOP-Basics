import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        List<Robot> robots = new ArrayList<>();
        List<Citizen> citizens = new ArrayList<>();
        while(!command.equals("End")){
            String tokens[] = command.split(" ");
            switch(tokens.length){
                case 2:
                    robots.add(new Robot(tokens[0],tokens[1]));
                    break;
                case 3:
                    citizens.add(new Citizen(tokens[0],Integer.parseInt(tokens[1]),tokens[2]));
                    break;
            }

            command = reader.readLine();
        }
        String id = reader.readLine();
        robots.stream().filter(r -> r.getId().endsWith(id)).forEach(r -> System.out.println(r.getId()));
        citizens.stream().filter(r -> r.getId().endsWith(id)).forEach(c -> System.out.println(c.getId()));

    }
}
