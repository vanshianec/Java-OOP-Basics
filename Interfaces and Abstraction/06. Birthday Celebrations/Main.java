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
        List<Citizen> citizens = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        while(!command.equals("End")){
            String tokens[] = command.split(" ");
            switch(tokens[0]){
                case "Pet":
                    pets.add(new Pet(tokens[1],tokens[2]));
                    break;
                case "Citizen":
                    citizens.add(new Citizen(tokens[1],Integer.parseInt(tokens[2]),tokens[3],tokens[4]));
                    break;
            }

            command = reader.readLine();
        }
        String year = reader.readLine();
        pets.stream().filter(r -> r.getBirthDate().endsWith(year)).forEach(r -> System.out.println(r.getBirthDate()));
        citizens.stream().filter(c -> c.getBirthDate().endsWith(year)).forEach(c -> System.out.println(c.getBirthDate()));

    }
}
