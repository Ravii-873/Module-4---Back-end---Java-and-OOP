public class Ex2 {
    public static void main(String[] args) {
        
        // Change to "123", "abcdef" or null to test try / catch
        String s = "3035 Teach";
        int num = -1;

        try {
            num = Integer.parseInt(s.trim());
            // s.trim() throws null pointer exception if s == null. Integer.parseInt() doesn't.
        } catch(NumberFormatException exception) {
            System.out.println("Erro! Não foi possível converter a String para int.");
            System.out.println(exception.getMessage() + "\n");
        } catch(NullPointerException exception) {
            System.out.println("Erro! String nula operada.");
            System.out.println(exception.getMessage() + "\n");
        }

        System.out.println("num: " + num);
    }
}