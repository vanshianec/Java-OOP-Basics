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
            String tokens[]=reader.readLine().split(" ");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostPerKm = Double.parseDouble(tokens[2]);
            Car car = new Car(model,fuelAmount,fuelCostPerKm);
            cars.add(car);
        }
        String command = reader.readLine();
        while(!command.equals("End")){
            String model = command.split(" ")[1];
            int distance = Integer.parseInt(command.split(" ")[2]);
            cars.stream().filter( car -> car.getModel().equals(model))
                    .forEach(car -> car.changeFuel(distance));
            command = reader.readLine();
        }
        for (Car car : cars) {
            System.out.printf("%s %.2f %d%n",car.getModel(),car.getFuelAmount(),car.getDistanceTraveled());
        }




    }
}

class Car{
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int distanceTraveled;

    public Car(String model,double fuelAmount,double fuelCostPerKm){
        this.model=model;
        this.fuelAmount=fuelAmount;
        this.fuelCostPerKm=fuelCostPerKm;
    }

    public String getModel(){
        return this.model;
    }
    public double getFuelAmount(){
        return this.fuelAmount;
    }
    public int getDistanceTraveled(){
        return this.distanceTraveled;
    }

    public void changeFuel(int distance){
        double fuelNeeded = fuelCostPerKm*distance;
        if(fuelAmount>=fuelNeeded){
            fuelAmount-=fuelNeeded;
            distanceTraveled+=distance;
        }
        else{
            System.out.println("Insufficient fuel for the drive");
        }
    }



}









