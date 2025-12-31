import java.util.Arrays;
import java.util.Scanner;

public class Codeforces492b {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt(), l = sc.nextInt();
        sc.nextLine();
        String[] nums = sc.nextLine().trim().split(" ");
        long[] arr = new long[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(nums[i]);
        }

        Arrays.sort(arr);
        long maxDist = 0L;

        for(int i = 1; i < n; i++) {
            maxDist = Math.max(maxDist, arr[i] - arr[i - 1]);
        }

        double ans = Math.max((double)maxDist / 2, Math.max(arr[0], l - arr[n - 1]));
        System.out.println(ans);
    }
}
