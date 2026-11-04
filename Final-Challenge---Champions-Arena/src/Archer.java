public class Archer extends Character {
    // Archer is fragile, but attacks very well
    public Archer(String name) {
        super(name, 100, 120, 60);
    }

    // Heals fixed 50 health points
    @Override
    public void heal() {
        if (getInventory() > 0) {
            // Heals 50
            setHealth(Math.min(getHealth() + 50, getMaxHealth()));
            setInventory(getInventory() - 1);
            System.out.println(this.getName() + ", um arqueiro, usou uma poção. Sua vida regenera em 50 pontos.");
            return;
        }
        System.out.println(this.getName() + " não tem poções disponíveis!");
    }
}
