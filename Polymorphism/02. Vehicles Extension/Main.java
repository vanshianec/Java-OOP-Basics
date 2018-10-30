import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

class Programming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carInfo = reader.readLine().split(" ");
        String[] truckInfo = reader.readLine().split(" ");
        String[] busInfo = reader.readLine().split(" ");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]),Double.parseDouble(carInfo[3]));
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]),Double.parseDouble(truckInfo[3]));
        Bus bus = new Bus(Double.parseDouble(busInfo[1]),Double.parseDouble(busInfo[2]),Double.parseDouble(busInfo[3]));
        int inputs = Integer.parseInt(reader.readLine());
        while (inputs-- > 0) {
            String input = reader.readLine();
            String command = input.split(" ")[0];
            String vehicle = input.split(" ")[1];
            double distanceOrFuel = Double.parseDouble(input.split(" ")[2]);
            try {
                switch (command) {
                    case "Drive":
                        if (vehicle.equals("Car")) {
                            car.drive(distanceOrFuel);
                        } else if (vehicle.equals("Truck")) {
                            truck.drive(distanceOrFuel);
                        }
                        else if (vehicle.equals("Bus")){
                            bus.addConsumption();
                            bus.drive(distanceOrFuel);
                            bus.removeConsumption();
                        }
                        break;
                    case "Refuel":
                        if (vehicle.equals("Car")) {
                            car.refuel(distanceOrFuel);
                        } else if (vehicle.equals("Truck")) {
                            truck.refuel(distanceOrFuel);
                        }
                        else if (vehicle.equals("Bus")){
                            bus.refuel(distanceOrFuel);
                        }
                        break;
                    case "DriveEmpty":
                        if(vehicle.equals("Bus")){
                        bus.drive(distanceOrFuel);
                        }
                }
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);



    }
}

abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKilometer;
    private double capacity;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKilometer,double capacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer);
        setCapacity(capacity);
    }

    private void setFuelQuantity(double amount) {
        if(amount<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = amount;
    }

    private void setCapacity(double amount){
        this.capacity=amount;
    }

    protected void setFuelConsumptionPerKilometer(double amount) {
        this.fuelConsumptionPerKilometer = amount;
    }

    public double getFuelConsumptionPerKilometer(){
        return this.fuelConsumptionPerKilometer;
    }

    public double getFuelQuantity(){
        return this.fuelQuantity;
    }

    protected void refuel(double amount) {
        if(amount<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if(amount>this.capacity){
           throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += amount;
    }

    protected void drive(double distance) {
        String throwMessage="";
        if (this.fuelQuantity < this.fuelConsumptionPerKilometer * distance) {
            throwMessage=String.format("%s needs refueling", this.getClass().getSimpleName());
            throw new IllegalArgumentException(throwMessage);
        }
            DecimalFormat format = new DecimalFormat("0.##");
            System.out.println(this.getClass().getSimpleName() + " travelled " + format.format(distance)+ " km");
            setFuelQuantity(this.fuelQuantity - this.fuelConsumptionPerKilometer * distance);
    }
    public String toString(){
        return String.format("%s: %.2f",this.getClass().getSimpleName(),getFuelQuantity());
    }


}

class Car extends Vehicle {

    protected Car(double fuelQuantity, double fuelConsumptionPerKilometer,double capacity) {
        super(fuelQuantity, fuelConsumptionPerKilometer + 0.9,capacity);
    }
}

class Truck extends Vehicle {
    protected final double PERCENTAGE = 0.95;
    protected  double n=2;
    protected Truck(double fuelQuantity, double fuelConsumptionPerKilometer,double capacity) {
        super(fuelQuantity, fuelConsumptionPerKilometer + 1.6,capacity);
    }

    @Override
    protected void refuel(double amount) {
        super.refuel(amount *  PERCENTAGE);
    }
}

class Bus extends  Vehicle{
    private final double LITERS = 1.4;
    protected Bus(double fuelQuantity,double fuelConsumptionPerKilometer, double capacity){
        super(fuelQuantity,fuelConsumptionPerKilometer,capacity);
    }
    public void addConsumption(){
        super.setFuelConsumptionPerKilometer(LITERS+super.getFuelConsumptionPerKilometer());
    }
    public void removeConsumption(){
        super.setFuelConsumptionPerKilometer(super.getFuelConsumptionPerKilometer()-LITERS);
    }

}


//bad practice just for testing purpose
