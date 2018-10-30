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
        List<Buyer> buyers = new ArrayList<>();
        int N = Integer.parseInt(reader.readLine());
        while (N-- > 0) {
            String tokens[] = reader.readLine().split(" ");
            switch (tokens.length) {
                case 3:
                    buyers.add(new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
                    break;
                case 4:
                    buyers.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]));
                    break;
            }
        }
        String name = reader.readLine();
        while (!name.equals("End")) {
            for (Buyer buyer : buyers) {
                if (buyer.getName().equals(name)) {
                    buyer.buyFood();
                }
            }
            name = reader.readLine();
        }
        int sum = 0;
        for (Buyer buyer : buyers) {
            sum += buyer.getFood();
        }
        System.out.println(sum);

    }
}
