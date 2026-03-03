import java.util.*;

public class Codeforces2124 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while(t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] line = scanner.nextLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            long ans = 1;

            for(int i = 1; i < n; i++) {
                long gcd = gcd(arr[i], arr[i - 1]);
                long k = arr[i - 1] / gcd;
                ans = lcm(ans, k);
            }
            System.out.println(ans);
        }
    }
    private static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    private static long gcd(long a, long b) {
        if(b > a) {
            gcd(b, a);
        }
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
