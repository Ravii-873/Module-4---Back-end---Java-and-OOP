import java.util.ArrayList;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Ex3 {
    public static void main(String[] args) {
        UnaryOperator<String> convert = s -> s.toUpperCase();
        
        ArrayList<String> list = new ArrayList<>();
        list.add("tSAjfasFoafjJ");
        list.add("fdppjAFjf93JJJJJJ");
        list.add("asdfhHHHH");
        list.add("IImOkkIk");
        list.add("gGgGgGgGgGgGgG");

        System.out.println("\nLista original:\n");
        list.forEach(i -> System.out.println("  " + i));
        System.out.println();
        
        ArrayList<String> newList = 
            list.stream()
            .map(convert)
            .collect(Collectors.toCollection(ArrayList::new));
        
        System.out.println("Nova lista:\n");
        newList.forEach(i -> System.out.println("  " + i));
        System.out.println();
    }
}