package app;

import app.Engines.Engine;
import app.IO.ConsoleInputReader;
import app.IO.ConsoleOutputWriter;
import app.Manager.HealthManager;
import app.Utilities.InputParser;

public class Main {
    public static void main(String[] args) {

        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser parser = new InputParser();
        HealthManager healthManager = new HealthManager();
        Engine engine = new Engine(inputReader,outputWriter,parser,healthManager);
        engine.run();

    }
}
