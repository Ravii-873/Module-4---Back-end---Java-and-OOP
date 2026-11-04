public class Enemy extends Character {
    // Enemy receives a name (see Main)
    // and draws it's attributes
    public Enemy(String name) {
        super(
                name,
                100 + (int) (Math.random() * 101),
                80 + (int) (Math.random() * 41),
                30 + (int) (Math.random() * 31));
    }
}
