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
        Smartphone smartphone = new Smartphone();
        String phoneNumbers[] = reader.readLine().split(" ");
        for (String phoneNumber : phoneNumbers) {
            smartphone.addNumber(phoneNumber);
        }
        String links [] = reader.readLine().split(" ");
        for (String link : links) {
            smartphone.addLink(link);
        }
        smartphone.calling();
        smartphone.browsing();
    }
}
