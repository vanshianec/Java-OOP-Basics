package app.Cells;

public abstract class BloodCell extends Cell {

    public BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    public String toString(){
        return super.toString();
    }
}
