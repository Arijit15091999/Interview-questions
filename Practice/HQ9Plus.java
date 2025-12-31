import java.util.Scanner;

public class HQ9Plus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        String ans = validate(word) ? "YES" : "NO";

        System.out.println(ans);
    }
    private static boolean validate(String word) {
        if(word == null || word.length() > 100) {
            return false;
        }

        for(char ch : word.toCharArray()) {
            if(ch == 'H' || ch == 'Q' || ch == '9') {
               return true;
            }
        }
        return false;
    }
}
