import java.util.HashSet;

public class Ex2 {
    
    public static void printHashSet(HashSet<String> hs) {
        System.out.println("\n  elementos:");
        hs.forEach(i -> {
            System.out.println("   " + i);
        });
        System.out.println();
    }
    public static void main(String[] args) {
        HashSet<String> colors = new HashSet<>();
        colors.add("vermelho");
        colors.add("amarelo");
        colors.add("verde");
        colors.add("azul");
        colors.add("violeta");
        
        System.out.println("HashSet de cores:");
        System.out.println("  tamanho: " + colors.size());
     
        printHashSet(colors);
        
        System.out.println("  *tentando duplicar \"violeta\"*");
        colors.add("violeta");
        
        printHashSet(colors);
        
        System.out.println("  *removendo \"verde\"*");
        colors.remove("verde");

        printHashSet(colors);

        System.out.println("  contém \"vermelho\": " + colors.contains("vermelho"));

        printHashSet(colors);
    }
}