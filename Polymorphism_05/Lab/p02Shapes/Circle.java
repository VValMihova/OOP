package Polymorphism_05.Lab.p02Shapes;

public class Circle extends Shape{
    private Double radius;

    @Override
    public Double calculatePerimeter() {
        return Math.PI*(radius*2);
    }

    @Override
    public Double calculateArea() {
        return Math.PI*(radius*radius);
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
