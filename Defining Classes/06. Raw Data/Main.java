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
        int N = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();
        while(N --> 0){
            String tokens[] = reader.readLine().split(" ");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tier1Pressure = Double.parseDouble(tokens[5]);
            int tier1Age = Integer.parseInt(tokens[6]);
            double tier2Pressure = Double.parseDouble(tokens[7]);
            int tier2Age = Integer.parseInt(tokens[8]);
            double tier3Pressure = Double.parseDouble(tokens[9]);
            int tier3Age = Integer.parseInt(tokens[10]);
            double tier4Pressure = Double.parseDouble(tokens[11]);
            int tier4Age = Integer.parseInt(tokens[12]);
            Car car = new Car(model,engineSpeed,enginePower,cargoWeight,cargoType,tier1Pressure,tier1Age,tier2Pressure,tier2Age,
                    tier3Pressure,tier3Age,tier4Pressure,tier4Age);
            cars.add(car);

        }
        String command = reader.readLine();
        switch (command){
            case"fragile":
                cars.stream().filter(car -> car.getCargoType().equals("fragile") && car.lowPressure())
                        .forEach(car -> System.out.println(car.getModel()));
                break;
            case"flamable":
                cars.stream().filter(car -> car.getCargoType().equals("flamable") && car.neededPower())
                        .forEach(car -> System.out.println(car.getModel()));
                break;
        }

    }
}

class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tier[] tiers;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, double tier1Pressure, int tier1Age,
               double tier2Pressure, int tier2Age, double tier3Pressure, int tier3Age, double tier4Pressure, int tier4Age) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tiers = new Tier[4];
        tiers[0] = new Tier(tier1Pressure, tier1Age);
        tiers[1] = new Tier(tier2Pressure, tier2Age);
        tiers[2] = new Tier(tier3Pressure, tier3Age);
        tiers[3] = new Tier(tier4Pressure, tier4Age);
    }
    public boolean lowPressure(){

        for (Tier tier : tiers) {
            if(tier.getPressure()<1){
                return true;
            }
        }
        return false;
    }
    public String getCargoType(){
        return cargo.getType();
    }
    public boolean neededPower(){
        if(engine.getPower()<=250){
            return false;
        }
        return true;
    }
    public String getModel(){
        return this.model;
    }

}

class Engine {
    private int speed;
    private int power;

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }
    public int getPower(){
        return this.power;
    }
}

class Cargo {
    private int weight;
    private String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}

class Tier {
    private double pressure;
    private int age;

    public Tier(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }
    public double getPressure(){
        return this.pressure;
    }
}
//bad practice just for testing purpose









