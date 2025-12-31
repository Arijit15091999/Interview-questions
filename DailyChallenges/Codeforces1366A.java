import java.util.Scanner;

public class Codeforces1366A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            sc.nextLine();
            long a = sc.nextLong(), b = sc.nextLong();

            System.out.println(
                    Math.min(
                            a,
                            Math.min(
                                    b,
                                    (a + b) / 3
                            )
                    )
            );
        }
    }
}
