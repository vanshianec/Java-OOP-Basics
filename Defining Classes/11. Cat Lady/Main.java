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


class Programming {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Cat> cats = new ArrayList<>();
        String input = reader.readLine();
        while (!input.equals("End")) {
            String breed = input.split(" ")[0];
            String name = input.split(" ")[1];
            double info = Double.parseDouble(input.split(" ")[2]);
            Cat cat;
            switch (breed) {
                case "Siames":
                    cat = new Siamese(name, info);
                    cats.add(cat);
                    break;
                case "Cymric":
                    cat = new Cymric(name, info);
                    cats.add(cat);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, info);
                    cats.add(cat);
                    break;
            }
            input = reader.readLine();
        }
        String catName = reader.readLine();
        for (Cat cat : cats) {
            if (cat.getName().equals(catName)) {
                System.out.println(cat);
             
            }
        }

    }
}

class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}

class Siamese extends Cat {

    private double earSize;

    public Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }


    public String toString() {
        return String.format("Siamese %s %.2f", getName(), earSize);
    }

}

class Cymric extends Cat {

    private double furLength;

    public Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    public String toString() {
        return String.format("Cymric %s %.2f", getName(), furLength);
    }


}

class StreetExtraordinaire extends Cat {

    private double decibels;

    public StreetExtraordinaire(String name, double decibels) {
        super(name);
        this.decibels = decibels;
    }

    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", getName(), decibels);
    }
}
// bad practice just for testing purpose












