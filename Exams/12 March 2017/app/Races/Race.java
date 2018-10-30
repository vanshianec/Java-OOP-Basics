package app.Races;

import app.Cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    protected Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Car car){
        this.participants.add(car);
    }

    public boolean hasCar(Car car){
        return participants.contains(car);
    }
    public List<Car> getParticipants(){
        return Collections.unmodifiableList(participants);
    }

    public int getLength() {
        return length;
    }

    public String getRoute() {
        return route;
    }

    public int getPrizePool() {
        return prizePool;
    }
    public abstract String getWinners();


}
