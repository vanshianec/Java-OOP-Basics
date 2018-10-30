public abstract class Shape {
    private double perimeter;
    private double area;


    protected abstract double calculatePerimeter();

    protected abstract double calculateArea();

    public double getPerimeter(){
        return calculatePerimeter();
    }
    public double getArea(){
        return calculateArea();
    }

}
