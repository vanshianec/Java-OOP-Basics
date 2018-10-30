

import Engine.Engine;
import IO.ConsoleInputReader;
import IO.ConsoleOutputWriter;
import Utilities.InputParser;
import Colony.Colony;

import java.nio.BufferOverflowException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        int [] input = Arrays.stream(inputReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Colony colony = new Colony(input[0],input[1]);
        Engine engine = new Engine(inputReader, outputWriter, inputParser,colony);
        engine.run();
    }
}