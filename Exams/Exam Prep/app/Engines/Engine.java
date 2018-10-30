package app.Engines;

import app.IO.ConsoleInputReader;
import app.IO.ConsoleOutputWriter;
import app.Manager.HealthManager;
import app.Utilities.InputParser;

import java.util.List;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private HealthManager healthManager;
    private static final String END_COMMAND = "BEER IF COMING";

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser,HealthManager healthManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.healthManager = healthManager;
    }

    public void run() {
        String inputLine;

        while(true) {
            inputLine = this.inputReader.readLine();
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);

            if (inputLine.equals("END_COMMAND")) {
                break;
            }
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);
        String organismName = "";
        String output = "";
        switch(command) {
            case "checkCondition":
                organismName = commandParams.get(0);
                output = this.healthManager.checkCondition(organismName);
                if(output !=null){
                    outputWriter.writeLine(output);
                }
                break;
            case "createOrganism":
                organismName = commandParams.get(0);
                output = this.healthManager.createOrganism(organismName);
                if(output !=null){
                    outputWriter.writeLine(output);
                }
                break;
            case "addCluster":
                organismName = commandParams.get(0);
                String id = commandParams.get(1);
                int rows = Integer.parseInt(commandParams.get(2));
                int cols = Integer.parseInt(commandParams.get(3));
                output = this.healthManager.addCluster(organismName,id,rows,cols);
                if(output !=null){
                    outputWriter.writeLine(output);
                }
                break;
            case "addCell":
                organismName = commandParams.get(0);
                String clusterId = commandParams.get(1);
                String cellType = commandParams.get(2);
                String cellId = commandParams.get(3);
                int health = Integer.parseInt(commandParams.get(4));
                int positionRow = Integer.parseInt(commandParams.get(5));
                int positionCol = Integer.parseInt(commandParams.get(6));
                int additionalProperty = Integer.parseInt(commandParams.get(7));
                output =this.healthManager.addCell(organismName,clusterId,cellType,cellId,
                        health,positionRow,positionCol,additionalProperty);
                if(output != null){
                    outputWriter.writeLine(output);
                }
                break;
            case "activateCluster":
                organismName = commandParams.get(0);
                outputWriter.writeLine(this.healthManager.activateCluster(organismName));
                break;

        }
    }
}