import java.util.Arrays;
import java.util.Scanner;

public class Codeforces1343C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            long[] arr = new long[n];
            String[] line = sc.nextLine().trim().split(" ");
            for(int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(line[i]);
            }
            long ans = solve(n, arr);
            System.out.println(ans);
        }
    }
    private static long solve(int n, long[] arr) {
        long[][] dp = new long[n + 1][n + 1];
        for(long[] d : dp) {
            Arrays.fill(d, -1);
        }
        return helper(n - 1, n, arr, n, dp);
    }
    private static long helper(int curr, int prev, long[] arr, int n, long[][] dp) {
        if(curr == -1) {
            return 0;
        }
        if(dp[curr][prev] != -1) {
            return dp[curr][prev];
        }
        // take
        long take = 0L;
        if(prev == n || !isSameSign(arr[curr], arr[prev])) {
            take += arr[curr] + helper(curr - 1, curr, arr, n, dp);
        }
        long notTake = helper(curr - 1, prev, arr, n, dp);

        return dp[curr][prev] = Math.max(take, notTake);
    }
    private static boolean isSameSign(long a, long b) {
        return (a > 0 && b > 0) || (a < 0 && b < 0);
    }
}
