package ex2;

public abstract class Animal {
    protected String name;
    protected String noise;

    public Animal(String name) {
        this.name = name;
    }

    public void makeNoise(){};

    public String getName() {
        return name;
    }

    public String getNoise() {
        return noise;
    }
}
