import java.util.Scanner;

public class CodeForces1360D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            sc.nextLine();
            System.out.println(solve(n , k));
        }
    }
    private static int solve(int n, int k) {
        int ans = n;

        for(int i = 1; i * i <= n; i++) {
            if(n % i == 0) {
                int d1 = i;
                int d2 = n / i;

                if(d1 <= k) {
                    ans = Math.min(ans, n / i);
                }
                if(d2 <= k) {
                    ans = Math.min(ans, d1);
                }
            }
        }

        return ans;
    }
}
