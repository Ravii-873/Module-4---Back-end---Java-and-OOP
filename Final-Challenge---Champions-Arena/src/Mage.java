public class Mage extends Character {
    // Mage is a middle ground between offense and defense
    public Mage(String name) {
        super(name, 200, 100, 80);
    }

    // Heals randomly, according to the possible values
    @Override
    public void heal() {
        if (getInventory() > 0) {
            // 1000 means a full heal
            int[] healValues = { 0, 10, 10, 60, 60, 60, 80, 80, 1000 };
            int randHeal = healValues[(int) (Math.random() * 9)];

            int pastHealth = getHealth();
            setHealth(Math.min(getHealth() + randHeal, getMaxHealth()));
            setInventory(getInventory() - 1);
            System.out.println(this.getName() + ", um mago, usou uma poção. Sua vida se cura em "
                    + (getHealth() - pastHealth) + " pontos.");
            return;
        }
        System.out.println(this.getName() + " não tem poções disponíveis!");
    }
}
