public class Ex1 {
    public static void main(String[] args) {
        
        int a = 5;
        int b = 0; // Change to test try / catch
        int div = 0;

        try {
            div = a / b;
        } catch(ArithmeticException exception) {
            System.out.println("Erro! Não foi possível atribuir: div = a / b;");
            System.out.println(exception.getMessage());
            System.out.println();
        }

        System.out.println("(int) div: " + div);
    }
}