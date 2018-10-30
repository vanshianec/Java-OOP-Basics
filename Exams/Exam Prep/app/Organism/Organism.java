package app.Organism;

import app.Cells.Cell;
import app.Cluster.Cluster;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Organism {
    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayList<>();
    }

    public boolean hasCluster(Cluster cluster){
        return clusters.contains(cluster);
    }

    public void addCluster(Cluster cluster){
        clusters.add(cluster);
    }

    public void addCellToCluster(Cell cell,String id){
        for (Cluster cluster : clusters) {
            if(cluster.getId().equals(id)){
                cluster.addCell(cell);
            }
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Organism - %s", this.name)).append(System.lineSeparator())
                .append(String.format("--Clusters: %d", this.clusters.size())).append(System.lineSeparator());
        int cellsCount = clusters.stream().mapToInt(cluster -> Integer.parseInt(cluster.getCellsCount()+"")).sum();
        sb.append(String.format("--Cells: %d",cellsCount)).append(System.lineSeparator());
        for (Cluster cluster : clusters) {
            sb.append(cluster.toString());
        }
        return sb.toString();

    }
}
