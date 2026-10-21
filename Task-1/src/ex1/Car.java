package ex1;

public class Car {
    private String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getDescription(){
        String description = "Brand: ";
        description += brand;
        description += ", Model: ";
        description += model;
        description += ", Year: ";
        description += String.valueOf(year);

        return description;
    }
}
