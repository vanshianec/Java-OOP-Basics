package app.ControllClass;

import app.Cars.Car;
import app.Cars.PerformanceCar;
import app.Cars.ShowCar;
import app.Races.CasualRace;
import app.Races.DragRace;
import app.Races.DriftRace;
import app.Races.Race;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import app.Garage.Garage;

public class CarManager {
    private static final String PERFORMANCE_CAR = "Performance";
    private static final String SHOW_CAR = "Show";
    private static final String CASUAL_RACE = "Casual";
    private static final String DRAG_RACE = "Drag";
    private static final String DRIFT_RACE = "Drift";
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
        this.garage = new Garage();
    }


    public void register(int id, String type, String brand, String model,
                         int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car car = null;
        switch (type) {
            case PERFORMANCE_CAR:
                car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            case SHOW_CAR:
                car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
        }
        if (car != null) {
            cars.put(id, car);
        }

    }

    public String check(int id) {

        if (cars.containsKey(id)) {
            return cars.get(id).toString();
        }
        return null;
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = null;
        switch (type) {
            case CASUAL_RACE:
                race = new CasualRace(length, route, prizePool);
                break;
            case DRAG_RACE:
                race = new DragRace(length, route, prizePool);
                break;
            case DRIFT_RACE:
                race = new DriftRace(length, route, prizePool);
                break;
        }
        if (race != null) {
            races.put(id, race);
        }

    }

    public void participate(int carId, int raceId) {
        Car car = cars.get(carId);
        if (garage.hasCar(car)) {
            return;
        }
        races.get(raceId).addParticipant(cars.get(carId));

    }

    public String start(int id) {
        Race race = races.get(id);
        List<Car> participants = race.getParticipants();
        StringBuilder winners = new StringBuilder();
        if (participants.isEmpty()) {
            return "“Cannot start the race with zero participants.";
        }

        winners.append(race.getRoute()).append(" - ").append(race.getLength()).append(System.lineSeparator());
        switch (race.getClass().getSimpleName()) {
            case "CasualRace":
                race = (CasualRace)race;
                winners.append(race.getWinners());
                break;
            case "DragRace":
                race = (DragRace)race;
                winners.append(race.getWinners());
                break;
            case "DriftRace":
                race = (DriftRace)race;
                winners.append(race.getWinners());
                break;
        }


        races.remove(id);
        return winners.toString();
    }

    public void park(int id) {
        Car car = cars.get(id);
        if (races.values().stream().anyMatch(race -> race.hasCar(car))) {
            return;
        }
        this.garage.parkCar(cars.get(id));
    }

    public void unpark(int id) {
        this.garage.unparkCar(cars.get(id));

    }

    public void tune(int tuneIndex, String addOn) {
        for (Car car : garage.getParkedCars()) {
            car.setSuspension(car.getSuspension() + tuneIndex / 2);
            car.setHorsePower(car.getHorsePower() + tuneIndex);
            switch (car.getClass().getSimpleName()) {
                case "PerformanceCar":
                    car = (PerformanceCar) car;
                    ((PerformanceCar) car).addAddOn(addOn);
                    break;
                case "ShowCar":
                    car = (ShowCar) car;
                    ((ShowCar) car).addStars(tuneIndex);
                    break;
            }
        }

    }
}
