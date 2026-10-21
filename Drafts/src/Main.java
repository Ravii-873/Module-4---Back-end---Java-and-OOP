import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    static Locale brazil = Locale.of("pt", "BR");
    static NumberFormat moneyBrazil = NumberFormat.getNumberInstance(brazil);
    public static void main(String[] args) {
        PP person = new PP("Arthur Epino", 1, SexEnum.PREFERNOTTOINFORM, 400);
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getSex());
        
        person.setName("Bixona");
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getSex());
        System.out.println(moneyBrazil.format(person.getIncomeTax()));
    }
}
