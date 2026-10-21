package ex3;

public class Main {
    public static void main(String[] args) {
        Shape r = new Rectangle(3, 4);
        Shape c = new Circle(5);

        System.out.printf("%.3f\n", r.calcArea());
        System.out.printf("%.3f\n", c.calcArea());
    }
}
