package app.Cells;

public class RedBloodCell extends BloodCell {
     private int velocity;
    public RedBloodCell(String id, int health, int positionRow, int positionCol,int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    public int getEnergy(){
        return super.getHealth()+this.velocity;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s--------Health %d | Velocity %d | Energy %d",super.toString(),super.getHealth(),this.velocity,this.getEnergy()))
        .append(System.lineSeparator());
        return sb.toString();
    }
}
