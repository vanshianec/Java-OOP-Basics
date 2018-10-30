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
        double length= Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());
        Box box = new Box(length,width,height);
        System.out.printf("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f%n"
                ,box.getSurfaceArea(),box.getLateralSurfaceArea(),box.getVolume());

    }
}

 class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getSurfaceArea(){
        return 2*length*width + 2*length*height + 2*width*height;
    }
    public double getLateralSurfaceArea(){
        return 2*length*height + 2*width*height;
    }
    public double getVolume(){
        return length*width*height;
    }
}
//bad practice just for testing purpose












