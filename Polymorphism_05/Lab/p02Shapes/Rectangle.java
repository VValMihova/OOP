package Polymorphism_05.Lab.p02Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    @Override
    public Double calculatePerimeter() {
        return height * 2 + width * 2;
    }

    @Override
    public Double calculateArea() {
        return height * width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }
}
