import java.util.Scanner;

public class Codeforces2181H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long w = sc.nextLong(), h = sc.nextLong(), d = sc.nextLong();
         sc.nextLine();
         long n = sc.nextLong();
        solve(w, h, d, n);
    }
    private static void solve(long w, long h, long d, long n) {
        long wc = gcd(w, n);
        long hc = gcd(h, n / wc);
        long dc = gcd( d, n / (wc * hc));
        if(wc * hc * dc != n) {
            System.out.println(-1);
        }else
            System.out.println((wc - 1) + " " + (hc - 1) + " " + (dc - 1));
    }
    private static long gcd(long a, long b) {
        if(a > b) {
            return gcdHelper(a, b);
        }
        return gcdHelper(b, a);
    }
    private static long gcdHelper(long a, long b) {
        if(b == 0) {
            return a;
        }
        return gcdHelper(b, a % b);
    }
}
