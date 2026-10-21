package ex2;

public class Cat extends Animal {
    Cat(String name) {
        super(name);
        this.noise = "Meow!";
    }

    @Override
    public void makeNoise() {
        for(int i=0; i<2; i++) {
            System.out.print(this.getNoise() + " ");
        }
        System.out.println();
    }
}
