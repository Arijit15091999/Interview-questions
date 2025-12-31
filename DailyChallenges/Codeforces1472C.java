import java.util.*;

public final class Codeforces1472C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] line = sc.nextLine().trim().split(" ");
            long[] arr = new long[n];

            for(int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(line[i]);
            }
            long ans = solve(n, arr);
            System.out.println(ans);
        }
    }

    private static long betterOne(int n, long[] arr) {
        long[] dp = new long[n + 1];
        long ans = 0L;
        dp[n] = 0;
        for(int i = n - 1; i >= 0; i--) {
            long newIndex = i + arr[i];
            long take = arr[i];
            if (newIndex < n) {
                take += dp[(int)newIndex];
            }
            dp[i] = take;

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    private static long solve(int n, long[] arr) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1L);
        helper(0, n, arr, dp);
        long ans = 0L;

        for(long d : dp) {
            ans = Math.max(ans, d);
        }
        return ans;
    }
    private static long helper(int index, int n, long[] arr, long[] dp) {
        if(index >= n) {
            return 0L;
        }
        if(dp[index] != -1L) {
            return dp[index];
        }
        // take
        long newIndex = index + arr[index];

        long take = arr[index];
        if (newIndex < n) {
            take += helper((int)newIndex, n, arr, dp);
        }
        dp[index] = take;
        // not Take
        long notTake = helper(index + 1, n, arr, dp);

        return take;
    }
}
