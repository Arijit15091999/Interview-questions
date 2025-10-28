import java.util.*;
public class Way_Too_Long_Words {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String word = sc.next();
            System.out.println(getCodedWord(word));
        }
    }
    private static String getCodedWord(String word) {
        int n = word.length();
        if(word.length() > 10) {
            return word.charAt(0) + String.valueOf(n - 2) + word.charAt(n - 1);
        }
        return word;
    }
}
