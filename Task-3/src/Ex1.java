import java.util.ArrayList;

public class Ex1 {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("maçã");
        fruits.add("banana");
        fruits.add("uva");
        fruits.add("abacaxi");
        fruits.add("morango");

        System.out.println("ArrayList de frutas - ");
        System.out.println("  tamanho: " + fruits.size());
        System.out.println("  terceiro elemento: " + fruits.get(2));
        
        System.out.println("\n  *removendo primeiro elemento*\n");
        fruits.remove(0);
        System.out.println("  contém \"abacaxi\": " + fruits.contains("abacaxi"));
        System.out.println("  contém \"melancia\": " + fruits.contains("melancia"));
        
        System.out.println("\n  elementos:");
        fruits.forEach(fruit -> {
            System.out.println("    " + fruit);
        });

        System.out.println();
    }
}