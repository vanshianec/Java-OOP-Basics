import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            Person person = null;
            try {
                person = new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3]));
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            if(person!=null){
                people.add(person);
            }
        }
        Team team = new Team("Minor");
        for (Person person : people) {
            team.addPlayer(person);
        }
        System.out.println("First team have "+team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have "+team.getReverseTeam().size() + " players");
    }
}











