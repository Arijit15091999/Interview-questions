import java.util.*;
public class Watermolon4a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();

        String ans = w > 2 && check(w) ? "YES" : "NO";

        System.out.println(ans);
    }
    private static boolean check(int w) {
        return w % 2 == 0;
    }
}
