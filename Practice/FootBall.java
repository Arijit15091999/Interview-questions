import java.util.Scanner;

public class FootBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pos = sc.nextLine();

        String pat1 = "1111111";
        String pat2 = "0000000";

        String verdict = pos.contains(pat1) || pos.contains(pat2) ? "YES" : "NO";

        System.out.println(verdict);
    }
}
