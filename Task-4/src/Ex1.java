import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex1 {
    public static void main(String[] args) {
        Predicate<Integer> predicate = (Integer i) -> i%2 == 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<10; i++)
            list.add((int)(Math.random()*50));
        list.forEach(i -> System.out.println("  " + i));

        System.out.println();
        
        ArrayList<Integer> newList = 
            list.stream()
            .filter(predicate)
            .collect(Collectors.toCollection(ArrayList::new));

        newList.forEach(i -> System.out.println("  " + i));
    }
}