import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Programming {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfEngines = Integer.parseInt(reader.readLine());
        ListEngine engines = new ArrayList();
        ListCar cars = new ArrayList();
        while(numberOfEngines --  0){
            String engineInfo[] = reader.readLine().split( );
            Engine engine;
            if(engineInfo.length==4){
                engine = new Engine(engineInfo[0],Integer.parseInt(engineInfo[1]),engineInfo[2],engineInfo[3]);
            }
            else if (engineInfo.length==3){
                engine = new Engine(engineInfo[0],Integer.parseInt(engineInfo[1]),engineInfo[2]);
            }
            else{
                engine = new Engine(engineInfo[0],Integer.parseInt(engineInfo[1]));
            }
            engines.add(engine);
        }
        int numberOfCars = Integer.parseInt(reader.readLine());
        while(numberOfCars -- 0){
            String carInfo[] = reader.readLine().split( );
            Car car;
            String engineModel = carInfo[1];
            for (Engine engine  engines) {
                if(engine.getModel().equals(engineModel)){
                    if(carInfo.length==4){
                        car = new Car(carInfo[0],engine,carInfo[2],carInfo[3]);
                    }
                    else if (carInfo.length==3){
                        car = new Car(carInfo[0],engine,carInfo[2]);
                    }
                    else{
                        car = new Car(carInfo[0],engine);
                    }
                    cars.add(car);
                    break;
                }

            }

        }
        for (Car car  cars) {
            System.out.print(car);
        }


    }
}

class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;
    public Car(String model,Engine engine){
        this(model,engine,na,na);
    }
    public Car(String model,Engine engine,String unknown){
        this.model=model;
        this.engine=engine;
        try{
            Integer.parseInt(unknown);
            weight=unknown;
            color = na;
        }
        catch (Exception e){
            color = unknown;
            weight=na;
        }

    }
    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }
    public String toString(){
        return String.format(%s%n%s%nPower %d%nDisplacement %s%nEfficiency %s%nWeight %s%nColor %s%n,
                model,engine.getModel(),engine.getPower(),engine.getDisplacement(),engine.getEfficiency(),weight,color);
    }

}

class Engine {
    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String model,int power) {
        this(model,power,na,na);
    }
    public Engine(String model, int power, String unknown){
        this.model=model;
        this.power=power;
        try{
            Integer.parseInt(unknown);
            displacement=unknown;
            efficiency=na;
        }
        catch(Exception e){
            displacement=na;
            efficiency=unknown;
        }
    }

    public Engine(String model,int power, String displacement,String efficiency) {
       this.model=model;
       this.power=power;
       this.displacement=displacement;
       this.efficiency=efficiency;
    }

    public String getModel(){
        return this.model;
    }
    public int getPower(){
        return this.power;
    }
    public String getDisplacement(){
        return this.displacement;
    }
    public String getEfficiency(){
        return this.efficiency;
    }
}
//bad practice just for testing purpose









