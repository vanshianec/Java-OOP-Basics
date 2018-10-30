package app.Cells;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }
    public int getHealth(){
        return this.health;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("------Cell %s [%d,%d]",this.id,this.positionRow,this.positionCol)).append(System.lineSeparator());
                return sb.toString();
    }
}
