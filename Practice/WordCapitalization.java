import java.util.Locale;
import java.util.Scanner;

public class WordCapitalization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String newStr = str.substring(0, 1).toUpperCase() + str.substring(1);
        System.out.println(newStr);
    }
}
