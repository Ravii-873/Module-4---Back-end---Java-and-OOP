package ex3;

public class Rectangle implements Shape {
    private double a, b;

    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calcArea() {
        return a * b;
    }

    double getA() {
        return a;
    }

    double getB() {
        return b;
    }
}
