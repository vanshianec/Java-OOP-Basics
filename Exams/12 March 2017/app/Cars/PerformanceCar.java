package app.Cars;

import java.util.ArrayList;
import java.util.Collection;

public class PerformanceCar extends Car {
    private Collection<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
        increaseHorsePower();
        decreaseSuspension();
        this.addOns = new ArrayList<>();
    }
    public String toString(){
        //Add-ons: {add-ons}”,
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator()).append("Add-ons: ");
        sb.append(addOns.size()==0 ? "None" : String.join(", ",addOns));
        return sb.toString();
    }
    public void addAddOn(String addOn){
        addOns.add(addOn);
    }
    public void increaseHorsePower(){
        super.setHorsePower(super.getHorsePower()+super.getHorsePower()/2);
    }
    public void decreaseSuspension(){
        super.setSuspension(super.getSuspension()-super.getSuspension()/4);
    }
}
