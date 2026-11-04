// Base class with generic attributes and methods
public class Character {
    // --- ATTRIBUTES ---
    private String name;
    private int health;
    private int maxHealth;
    private int attack;
    private int defense;
    private boolean isDefending;
    private int inventory;

    // Constructor
    public Character(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
        this.defense = defense;
        this.inventory = 3;
    }

    // --- METHODS ---

    // Calculates attack damage
    public void attack(Character target) {
        int damage;
        if (target.getIsDefending()) {
            damage = Math.max(getAttack() - target.getDefense(), 0);
            damage = Math.min(damage, target.getHealth());
        } else {
            damage = Math.min(getAttack(), target.getHealth());
        }
        target.receiveDamage(damage);
    }

    // Sets defending state
    public void defend() {
        setIsDefending(true);
    }

    // Receives actual damage
    public void receiveDamage(int damage) {
        // Clamp for safety
        if (damage < 0)
            return;
        setHealth(Math.max(health - damage, 0));
        System.out.println(name + " recebeu " + damage + " de dano!");
    }

    // Returns health state
    public boolean isAlive() {
        return health > 0;
    }

    // Base method
    public void heal() {
    }

    // --- GETTERS AND SETTERS ---

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        // Clamp for safety
        this.health = Math.max(0, Math.min(health, getMaxHealth()));
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public boolean getIsDefending() {
        return isDefending;
    }

    public void setIsDefending(boolean isDefending) {
        this.isDefending = isDefending;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        // Clamp for safety
        // There's no upper limit, because the player gets bonus potions every round
        this.inventory = Math.max(0, inventory);
    }
}
