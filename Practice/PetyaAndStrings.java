import java.util.Scanner;

public class PetyaAndStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(lexicoGraphicSortHelper(str1, str2));
    }
    private static int lexicoGraphicSortHelper(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        int n = str1.length();
        for(int i = 0; i < n; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if(ch1 < ch2) {
                return -1;
            }else if(ch1 > ch2) {
                return 1;
            }
        }
        return 0;
    }
}
