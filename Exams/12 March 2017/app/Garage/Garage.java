package app.Garage;

import app.Cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public Garage(){
        this.parkedCars = new ArrayList<>();
    }

    public void parkCar(Car car){
        this.parkedCars.add(car);
    }
    public void unparkCar(Car car){
        this.parkedCars.remove(car);
    }
    public boolean hasCar(Car car){
        return parkedCars.contains(car);
    }
    public Collection<Car> getParkedCars(){
        return Collections.unmodifiableList(parkedCars);
    }


}
