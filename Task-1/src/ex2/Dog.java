package ex2;

public class Dog extends Animal {
    Dog(String name) {
        super(name);
        this.noise = "Woof!";
    }

    @Override
    public void makeNoise() {
        for(int i=0; i<3; i++) {
            System.out.print(this.getNoise() + " ");
        }
        System.out.println();
    }
}
