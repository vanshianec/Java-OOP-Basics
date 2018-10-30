public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height,double width){
        this.height=height;
        this.width=width;
    }


    @Override
    public double calculatePerimeter() {
        return 2*width+2*height;
    }

    @Override
    public double calculateArea() {
        return height*width;
    }

    public double getHeight(){
        return this.height;
    }
    public double getWidth(){
        return this.width;
    }
}
