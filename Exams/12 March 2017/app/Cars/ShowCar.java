package app.Cars;

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
        this.stars = 0;
    }

    public String toString(){
        //“{stars} *”,
        StringBuilder sb = new StringBuilder(super.toString());



        sb.append(System.lineSeparator()).append(String.format("%d *", this.stars));

        return sb.toString();

    }
    public void addStars(int stars){
        this.stars += stars;
    }
}
