package app.Manager;

import app.Cells.Cell;
import app.Cells.RedBloodCell;
import app.Cells.WhiteBloodCell;
import app.Cluster.Cluster;
import app.Microbes.Bacteria;
import app.Microbes.Fungi;
import app.Microbes.Virus;
import app.Organism.Organism;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HealthManager {

    private Map<String,Organism> organisms;

    public HealthManager(){
        organisms = new LinkedHashMap<>();
    }

    public String checkCondition(String organismName){
        if(organisms.containsKey(organismName)){
            return organisms.get(organismName).toString().trim();
        }
        return null;
    }
    public String createOrganism(String name){
        Organism organism = new Organism(name);
        if(organisms.containsKey(name)){
           return String.format("Organism %s already exists",name);
        }
        organisms.put(name,organism);
        return "Created organism "+name;

    }
    public String addCluster(String organismName,String id,int rows,int cols){
        Cluster cluster = new Cluster(id,rows,cols);
        if(organisms.containsKey(organismName)){
           Organism organism = organisms.get(organismName);
           if(!organism.hasCluster(cluster)){
               organisms.get(organismName).addCluster(cluster);
               return String.format("Organism %s: Created cluster %s",organismName,id);
           }
        }
        return null;
    }
    public String addCell(String organismName,String clusterId,String cellType, String cellId,int health,int positionRow,
                          int positionCol,int additionalProperty){
        Cell cell = null;
        switch(cellType){
            case "WhiteBloodCell":
                cell = new WhiteBloodCell(cellId,health,positionRow,positionCol,additionalProperty);
                break;
            case "RedBloodCell":
                cell = new RedBloodCell(cellId,health,positionRow,positionCol,additionalProperty);
                break;
            case "Virus":
                cell = new Virus(cellId,health,positionRow,positionCol,additionalProperty);
                break;
            case "Fungi":
                cell = new Fungi(cellId,health,positionRow,positionCol,additionalProperty);
                break;
            case "Bacteria":
                cell = new Bacteria(cellId,health,positionRow,positionCol,additionalProperty);
                break;
        }
        if(organisms.containsKey(organismName)){
             organisms.get(organismName).addCellToCluster(cell,clusterId);
        }

        return String.format("Organism %s: Created cell %s in cluster %s",organismName,cellId,clusterId);
    }
    public String activateCluster(String organismName){
        return "Activated";
    }


}
