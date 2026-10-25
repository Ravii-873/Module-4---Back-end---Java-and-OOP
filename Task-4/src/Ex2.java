import java.math.BigInteger;
import java.util.function.Predicate;

public class Ex2 {
    public static void main(String[] args) {
        Predicate<BigInteger> isPrime = p -> {
            if(p.compareTo(BigInteger.TWO) < 0) return false;
            if(p.compareTo(BigInteger.TWO) == 0) return true;
            BigInteger LIMIT = p.sqrt();
            for(BigInteger i=BigInteger.TWO; i.compareTo(LIMIT) <= 0; i = i.add(BigInteger.ONE)){
                // System.out.println(i);
                if(p.mod(i).equals(BigInteger.ZERO)) return false;
            }
            return true;
        };

        BigInteger p = new BigInteger("10000000000000061");
        System.out.println(isPrime.test(p));
    }
}