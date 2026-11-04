public class Warrior extends Character {
    // Warrior is brute, but doesn't attack well
    public Warrior(String name) {
        super(name, 240, 80, 70);
    }

    // Heals 50% of the current health value
    @Override
    public void heal() {
        if (getInventory() > 0) {
            // Heals 50%
            setHealth((int) Math.min(getHealth() * 1.5, getMaxHealth()));
            setInventory(getInventory() - 1);
            System.out.println(this.getName() + ", um guerreiro, usou uma poção. Sua vida regenera em 50%.");
            return;
        }
        System.out.println(this.getName() + " não tem poções disponíveis!");
    }
}
