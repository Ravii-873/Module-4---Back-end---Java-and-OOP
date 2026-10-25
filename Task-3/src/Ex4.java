import java.util.ArrayList;
import java.util.HashSet;

public class Ex4 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("lapiseira");   
        al.add("computador");   
        al.add("3035Tech");   
        al.add("café");   
        al.add("programador");   

        System.out.println("ArrayList:");
        al.forEach(s -> {
            System.out.println("  " + s);
        });
        
        System.out.println("\nCopiando do AL para o HS\n");
        HashSet<String> hs = new HashSet<>();
        al.forEach(s -> {
            hs.add(s);
        });

        System.out.println("HashSet:");
        hs.forEach(s -> {
            System.out.println("  " + s);
        });

        System.out.println("\nRecopiando do HS para outro AL\n");
        ArrayList<String> newAl = new ArrayList<>();
        hs.forEach(s -> {
            newAl.add(s);
        });

        System.out.println("New ArrayList:");
        newAl.forEach(s -> {
            System.out.println("  " + s);
        });

        System.out.println("\nSim, a ordem muda durante as conversões!");
    }
}