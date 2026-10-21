package ex1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Insert car's brand, model and year: ");
        String brand = scan.nextLine();
        String model = scan.nextLine();
        int year = scan.nextInt();
        
        Car car = new Car(brand, model, year);
        System.out.println(car.getDescription());

        scan.close();
    }
}
