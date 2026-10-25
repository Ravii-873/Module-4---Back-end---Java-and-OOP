import java.util.function.Function;

public class Ex4 {
    public static void main(String[] args) {
        Function<int[], Integer> sumAll = list -> {
            Integer sum = 0;
            for(int i=0; i<list.length; i++)
                sum += list[i];
            return sum;
        };
        
        int[] list = new int[10];
        for(int i=0; i<list.length; i++)
            list[i] = i;

        int sum = sumAll.apply(list);
        System.out.println(sum);
    }
}