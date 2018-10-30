package app.Cells;

public class WhiteBloodCell extends BloodCell{
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol,int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    public int getEnergy(){
        return (super.getHealth()+this.size)*2;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s--------Health %d | Size %d | Energy %d",super.toString(),super.getHealth(),this.size,this.getEnergy()))
        .append(System.lineSeparator());
        return sb.toString();
    }
}
