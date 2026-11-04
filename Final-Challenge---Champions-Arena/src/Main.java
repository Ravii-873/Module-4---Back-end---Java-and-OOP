import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static int battlesWon = 0;

    // --- MAIN ---

    public static void main(String[] args) {
        Character player = startGame();

        // Runs while:
        // Player is alive
        // Player didn't voluntary end his game
        // Player didn't won 3 battles
        for (int i = 0; i < 3 && player.isAlive(); i++) {
            // Automatic heal before every round
            System.out.println(player.getName() + " será curado com duas poções gratuitas antes da batalha!");
            player.setInventory(player.getInventory() + 2);
            player.heal();
            player.heal();

            Enemy enemy = generateEnemy();
            System.out.println("\nUm inimigo spawnou: " + enemy.getName() + "!");

            boolean wonRound = battle(player, enemy);

            if (wonRound) {
                battlesWon++;
                System.out.println(enemy.getName() + " foi derrotado!");
                System.out.println("Batalhas vencidas até agora: " + battlesWon);

                // Victory or voluntary end
                if (battlesWon >= 3 || !askToContinue()) {
                    break;
                }
            }
        }

        gameOver(player);
        scan.close();
    }

    // --- BEFORE GAME ---

    // Creates the player with the entered data
    static Character startGame() {
        System.out.println("=== Bem-vindo à Arena dos Campeões! ===");
        System.out.print("Insira seu nome: ");
        String name = scan.nextLine();

        System.out.println("\nEscolha sua classe:");
        System.out.println("1 - Guerreiro");
        System.out.println("2 - Mago");
        System.out.println("3 - Arqueiro");

        int chosen = readValid(1, 3);

        Character player;
        switch (chosen) {
            case 1:
                player = new Warrior(name);
                break;
            case 2:
                player = new Mage(name);
                break;
            default:
                player = new Archer(name);
                break;
        }

        System.out.println("\nClasse escolhida!");
        return player;
    }

    // Generates random enemy:
    // Name, health, attack and defense
    static Enemy generateEnemy() {
        String[] names = { "Zargor", "Ork", "Nyla", "Mildrogdon", "Embolop", "Cycloneo", "Zombiog" };
        String drawnName = names[(int) (Math.random() * names.length)];
        return new Enemy(drawnName);
    }

    // --- BATTLES ---

    // Rounds' battles
    static boolean battle(Character player, Enemy enemy) {
        int turn = 1;

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\n--- Turno " + turn + " ---");
            showStatus(player, enemy);

            // Stores chosen action to apply
            int pPlay = playersTurn(player, enemy);
            int ePlay = enemysTurn(enemy, player);

            // Applies actions
            if (pPlay == 1)
                player.attack(enemy);
            if (!enemy.isAlive())
                break;
            if (ePlay == 1)
                enemy.attack(player);

            turn++;
        }

        return enemy.isAlive() == false;
    }

    // Summarize current player's and enemy's information
    static void showStatus(Character player, Enemy enemy) {
        System.out.println(player.getName() + " | Vida: " + player.getHealth());
        System.out.println(player.getName() + " | Ataque: " + player.getAttack());
        System.out.println(player.getName() + " | Defesa: " + player.getDefense());
        System.out.println(player.getName() + " | Inventário: " + player.getInventory());
        System.out.println(enemy.getName() + " | Vida: " + enemy.getHealth());
        System.out.println(enemy.getName() + " | Ataque: " + enemy.getAttack());
        System.out.println(enemy.getName() + " | Defesa: " + enemy.getDefense());
    }

    // Asks player for his action
    static int playersTurn(Character player, Enemy enemy) {
        System.out.println("\nEscolha sua ação:");
        System.out.println("1 - Atacar");
        System.out.println("2 - Defender");
        System.out.println("3 - Usar Poção de Cura (" + player.getInventory() + " restante(s))");

        int action = readValid(1, 3);
        // Reset isDefending
        player.setIsDefending(false);

        // Defending and healing are processed
        // BEFORE attacking
        switch (action) {
            case 2:
                player.defend();
                break;
            case 3:
                player.heal();
                break;
        }

        return action;
    }

    // Draws enemy's action
    static int enemysTurn(Enemy enemy, Character player) {
        enemy.setIsDefending(false);
        double chance = Math.random();

        if (chance < 0.75) {
            // 75% attacking
            System.out.println(enemy.getName() + " atacará!");
            return 1;
        } else {
            // 25% defending
            System.out.println(enemy.getName() + " está se defendendo!");
            enemy.defend();
            return 2;
        }
    }

    // --- GAME OVER ---

    // Shows the final result and ends the game
    static void gameOver(Character player) {
        System.out.println("\n=== Fim de Jogo ===");
        if (player.isAlive() && battlesWon < 3) {
            System.out.println(player.getName() + " encerrou voluntariamente sua jornada após " + battlesWon
                    + " batalhas vencidas.");
        } else if (player.isAlive()) {
            System.out.println(player.getName() + " encerrou a jornada como campeão da arena!");
        } else {
            System.out.println(player.getName() + " caiu em batalha...");
        }
        System.out.println("Total de batalhas vencidas: " + battlesWon);
    }

    // --- UTILITIES ---

    // Reads a valid integer within a specified range
    static int readValid(int min, int max) {
        int option = -1;
        boolean ok = false;

        while (!ok) {
            System.out.print("Escolha uma opção (" + min + "-" + max + "): ");
            try {
                option = scan.nextInt();
                scan.nextLine();

                if (option >= min && option <= max) {
                    ok = true;
                } else {
                    System.out.println("Opção fora do intervalo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scan.nextLine();
            }
        }

        return option;
    }

    // Ask the player if he wishes to continue
    static boolean askToContinue() {
        System.out.println("\nDeseja enfrentar outro inimigo?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não, encerrar por aqui");
        int option = readValid(1, 2);
        return option == 1;
    }
}
