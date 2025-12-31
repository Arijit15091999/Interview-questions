import java.util.Scanner;

public class Codeforces466A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        if(m * a > b) {
            int count = n / m;
            int rem = n % m;
            int ans = count * b + Math.min(rem * a, b);
            System.out.println(ans);
        }else
            System.out.println(n * a);
    }
}
