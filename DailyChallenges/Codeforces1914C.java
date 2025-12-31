import java.util.Scanner;

public final class Codeforces1914C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            sc.nextLine();
            String[] line1 = sc.nextLine().trim().split(" ");
            String[] line2 = sc.nextLine().trim().split(" ");
            Long[] nums1 = new Long[n];
            Long[] nums2 = new Long[n];

            for(int i = 0; i < n; i++) {
                nums1[i] = Long.parseLong(line1[i]);
                nums2[i] = Long.parseLong(line2[i]);
            }

            Long ans = solve(n, k, nums1, nums2);
            System.out.println(ans);
        }
    }

    private static Long solve(int n, int k, Long[] a, Long[] b) {
        Long maxValue = Long.MIN_VALUE;
        Long ans = Long.MIN_VALUE;
        Long sum = 0L;
        for(int i = 0; i < Math.min(n, k); i++) {
            sum += a[i];
            maxValue = Math.max(maxValue, b[i]);

            ans = Math.max(ans, sum + maxValue * (k - i - 1));
        }

        return ans;
    }
}
