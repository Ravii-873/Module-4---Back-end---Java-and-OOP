import java.util.ArrayList;
import java.util.HashSet;

public class Ex5 {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();

        for(int i=0; i<10; i++)
            al.add((int)(Math.random()*50));

        System.out.println("ArrayList original:");
        al.forEach(i -> {
            System.out.println("  " + i);
        });

        for(int i=0; i<al.size(); i++)
            if(al.get(i) % 2 == 0)
                al.remove(i);
            
        System.out.println("\nArrayList após remoções:");
        al.forEach(i -> {
            System.out.println("  " + i);
        });

        HashSet<Integer> hs = new HashSet<>(al);

        System.out.println("\nHashSet:");
        hs.forEach(i -> {
            System.out.println("  " + i);
        });

        System.out.println("\nContém 5?: " + hs.contains(5));
        System.out.println("Contém 13?: " + hs.contains(13));
        System.out.println("Contém 39?: " + hs.contains(39));
    }
}