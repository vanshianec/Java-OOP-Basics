package app.Cluster;

import app.Cells.Cell;
import app.Cells.RedBloodCell;
import app.Cells.WhiteBloodCell;
import app.Microbes.Bacteria;
import app.Microbes.Fungi;
import app.Microbes.Virus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Cluster {

    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    public int getCellsCount(){
        return cells.size();
    }

    public String getId(){
        return this.id;
    }

    public void addCell(Cell cell){
        cells.add(cell);
    }



    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("----Cluster %s",this.id)).append(System.lineSeparator());
        for (Cell cell : cells) {
            switch(cell.getClass().getSimpleName()){
                case "RedBloodCell":
                    sb.append((RedBloodCell)cell);
                    break;
                case "WhiteBloodCell":
                    sb.append((WhiteBloodCell)cell);
                    break;
                case "Virus":
                    sb.append((Virus)cell);
                    break;
                case "Fungi":
                    sb.append((Fungi)cell);
                    break;
                case "Bacteria":
                    sb.append((Bacteria)cell);
                    break;
            }
        }
       return sb.toString();
    }

}
