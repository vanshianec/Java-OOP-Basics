package app.Cars;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsePower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected Car(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsePower = horsePower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getDurability() {
        return durability;
    }

    public int getHorsePower() {

        return horsePower;
    }

    public int getSuspension() {
        return suspension;
    }

    public void setHorsePower(int horsePower){
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setSuspension(int suspension){
        this.suspension = suspension;

    }

    public Integer getOverallPerformance(){
        return (this.horsePower/this.acceleration)+(this.suspension+this.durability);
    }
    public Integer getEnginePerformance(){
        return (this.horsePower/this.acceleration);
    }
    public Integer getSuspensionPerformance(){
        return this.suspension + this.durability;
    }

    public String toString(){
        /*
        o	“{brand} {model} {yearOfProduction}
o	 {horsepower} HP, 100 m/h in {acceleration} s
o	 {suspension} Suspension force, {durability} Durability”

         */
        StringBuilder sb = new StringBuilder();

        sb.append(this.brand).append(" ").append(this.model).append(" ").append(this.yearOfProduction)
                .append(System.lineSeparator()).append(this.horsePower).append(" HP, 100 m/h in ").append(this.acceleration)
                .append(" s").append(System.lineSeparator()).append(this.suspension).append(" Suspension force, ")
                .append(this.durability).append(" Durability");
        return sb.toString();
    }



}
