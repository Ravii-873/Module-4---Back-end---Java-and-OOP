import java.util.ArrayList;
import java.util.HashSet;

public class Ex3 {

    public static void printBoth(ArrayList<Integer> al, HashSet<Integer> hs) {
        System.out.println();
        System.out.println("  ArrayList:");
        al.forEach(i -> {
            System.out.println("    " + i);
        });
        System.out.println();
        System.out.println("  HashSet:");
        hs.forEach(i -> {
            System.out.println("    " + i);
        });
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<10; i++) {
            int aux = (int)(Math.random() * 20);
            al.add(aux);
            hs.add(aux);
        }

        printBoth(al, hs);

        System.out.println("Diferença entre a ordem dos elementos nos dois - explicada em ../Ex3 Explanation.txt");
    }
}