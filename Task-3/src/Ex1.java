import java.util.ArrayList;

public class Ex1 {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("grape");
        fruits.add("pineapple");
        fruits.add("strawberry");

        System.out.println("fruits'");
        System.out.println("  size: " + fruits.size());
        System.out.println("  3rd element: " + fruits.get(2));
        
        fruits.remove(0);
        System.out.println("  contains \"pineapple\": " + fruits.contains("pineapple"));
        System.out.println("  contains \"watermelon\": " + fruits.contains("watermelon"));
        
        System.out.println("\n  elements:");
        fruits.forEach(fruit -> {
            System.out.println("    " + fruit);
        });

        System.out.println();
    }
}