package app.Engines;

import app.IO.ConsoleInputReader;
import app.IO.ConsoleOutputWriter;
import app.Utilities.InputParser;
import app.ControllClass.CarManager;


import java.util.List;

public class Engine {
    private static final String END_COMMAND = "Cops Are Here";
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private CarManager carManager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser,CarManager carManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.carManager = carManager;
    }

    public void run() {
        String inputLine;

        while(true) {
            inputLine = this.inputReader.readLine();
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);

            if (inputLine.equals(END_COMMAND)) {
                break;
            }
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);
        int id = 0;
        String type = "";
        int raceId = 0;
        int carId = 0;
        switch(command) {

            case "register":
                id = Integer.parseInt(commandParams.get(0));
                type = commandParams.get(1);
                String brand = commandParams.get(2);
                String model = commandParams.get(3);
                int yearOfProduction = Integer.parseInt(commandParams.get(4));
                int horsepower = Integer.parseInt(commandParams.get(5));
                int acceleration = Integer.parseInt(commandParams.get(6));
                int suspension = Integer.parseInt(commandParams.get(7));
                int durability = Integer.parseInt(commandParams.get(8));
                this.carManager.register(id,type,brand,model,yearOfProduction,horsepower,acceleration,suspension,durability);
                break;

            case "check":
                id = Integer.parseInt(commandParams.get(0));
                outputWriter.writeLine(this.carManager.check(id));
                break;

            case "open":
                id = Integer.parseInt(commandParams.get(0));
                type = commandParams.get(1);
                int length = Integer.parseInt(commandParams.get(2));
                String route = commandParams.get(3);
                int prizePool = Integer.parseInt(commandParams.get(4));
                this.carManager.open(id,type,length,route,prizePool);
                break;
            case "participate":
                carId = Integer.parseInt(commandParams.get(0));
                raceId = Integer.parseInt(commandParams.get(1));
                this.carManager.participate(carId,raceId);
                break;
            case "start":
                raceId = Integer.parseInt(commandParams.get(0));
                outputWriter.writeLine(this.carManager.start(raceId));
                break;
            case "park":
                carId = Integer.parseInt(commandParams.get(0));
                this.carManager.park(carId);
                break;
            case "unpark":
                carId = Integer.parseInt(commandParams.get(0));
                this.carManager.unpark(carId);
                break;
            case "tune":
                int tuneIndex = Integer.parseInt(commandParams.get(0));
                String tuneAddOn = commandParams.get(1);
                this.carManager.tune(tuneIndex,tuneAddOn);
                break;

        }
    }
}