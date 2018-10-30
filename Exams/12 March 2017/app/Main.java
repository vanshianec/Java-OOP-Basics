package app;

import app.ControllClass.CarManager;
import app.Engines.Engine;
import app.IO.ConsoleInputReader;
import app.IO.ConsoleOutputWriter;
import app.Utilities.InputParser;

public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader= new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser parser = new InputParser();
        CarManager carManager = new CarManager();
        Engine engine = new Engine(inputReader,outputWriter,parser,carManager);
        engine.run();
    }
}
