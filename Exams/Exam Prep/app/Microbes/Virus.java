package app.Microbes;

public class Virus extends Microbe {
    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    public int getEnergy(){
        return super.getHealth()+super.getVirulence();
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s--------Health %d | Virulence %d | Energy %d",super.toString(),super.getHealth(),super.getVirulence(),this.getEnergy()))
        .append(System.lineSeparator());
        return sb.toString();
    }
}
