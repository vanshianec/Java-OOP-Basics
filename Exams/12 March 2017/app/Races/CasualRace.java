package app.Races;

import app.Cars.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }
    public String getWinners() {
        List<Car> participants = super.getParticipants();
        participants=participants.stream().sorted((c2, c1) -> c1.getOverallPerformance().compareTo(c2.getOverallPerformance()))
                .limit(3).collect(Collectors.toList());
        int counter = 1;
        int prizePool = 0;
        StringBuilder winners = new StringBuilder();
        for (Car participant : participants) {
            if(counter==1){
                prizePool = this.getPrizePool() / 2;
            }
            else if(counter==2){
                prizePool = (this.getPrizePool()*3) / 10;
            }
            else if (counter ==3){
                prizePool = this.getPrizePool() / 5;
            }
            String format = String.format("%d. %s %s %dPP - $%d",counter, participant.getBrand(), participant.getModel()
                    ,participant.getOverallPerformance(),prizePool);
            winners.append(format);
            if(counter!=participants.size()){
                winners.append(System.lineSeparator());
            }
            counter++;
        }
        return winners.toString();

    }
}
