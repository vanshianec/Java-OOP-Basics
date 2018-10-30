import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

class Programming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carInfo = reader.readLine().split(" ");
        String[] truckInfo = reader.readLine().split(" ");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int inputs = Integer.parseInt(reader.readLine());
        while (inputs-- > 0) {
            String input = reader.readLine();
            String command = input.split(" ")[0];
            String vehicle = input.split(" ")[1];
            double distanceOrFuel = Double.parseDouble(input.split(" ")[2]);
            switch (command) {
                case "Drive":
                    if (vehicle.equals("Car")) {
                        car.drive(distanceOrFuel);
                    }
                    else if(vehicle.equals("Truck")){
                       truck.drive(distanceOrFuel);
                    }
                    break;
                case "Refuel":
                    if (vehicle.equals("Car")) {
                        car.refuel(distanceOrFuel);
                    }
                    else if(vehicle.equals("Truck")){
                        truck.refuel(distanceOrFuel);
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);



    }
}

abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKilometer;


    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKilometer) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer);
    }

    private void setFuelQuantity(double amount) {
        this.fuelQuantity = amount;
    }

    private void setFuelConsumptionPerKilometer(double amount) {
        this.fuelConsumptionPerKilometer = amount;
    }

    public double getFuelQuantity(){
        return this.fuelQuantity;
    }

    protected void refuel(double amount) {
        this.fuelQuantity += amount;
    }

    protected void drive(double distance) {
        if (this.fuelQuantity < this.fuelConsumptionPerKilometer * distance) {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
        else {
            DecimalFormat format = new DecimalFormat("0.##");
            System.out.println(this.getClass().getSimpleName() + " travelled " + format.format(distance)+ " km");
            setFuelQuantity(this.fuelQuantity - this.fuelConsumptionPerKilometer * distance);
        }
    }
    public String toString(){
        return String.format("%s: %.2f",this.getClass().getSimpleName(),getFuelQuantity());
    }


}

class Car extends Vehicle {
    protected Car(double fuelQuantity, double fuelConsumptionPerKilometer) {
        super(fuelQuantity, fuelConsumptionPerKilometer + 0.9);
    }
}

class Truck extends Vehicle {

    protected Truck(double fuelQuantity, double fuelConsumptionPerKilometer) {
        super(fuelQuantity, fuelConsumptionPerKilometer + 1.6);
    }

    @Override
    protected void refuel(double amount) {
        super.refuel(amount * 0.95);
    }
}

//bad practice just for testing purpose


