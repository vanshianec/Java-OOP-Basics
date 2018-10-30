public class Circle extends Shape{
    private double radius;

    public Circle(double radius){
        this.radius=radius;
    }

    public double calculatePerimeter(){
        return 2 * this.radius * Math.PI;
    }
    public double calculateArea(){
        return Math.PI*(this.radius*this.radius);
    }
    public final double getRadius(){
        return this.radius;
    }
}
