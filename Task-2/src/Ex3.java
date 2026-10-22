import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int num = -1;
        String aux = scan.nextLine();

        try {
            num = Integer.parseInt(aux);
        } catch(NumberFormatException exception) {
            System.out.println("Erro! Não foi possível converter String para int.");
            System.out.println(exception.getMessage() + "\n");
        } finally {
            System.out.println("Valor final de num: " + num + "\n");
        }

        scan.close();
    }
}