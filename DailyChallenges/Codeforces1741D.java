import java.util.Scanner;

public final class Codeforces1741D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0) {
            int m = sc.nextInt();
            sc.nextLine();
            String[] line = sc.nextLine().trim().split(" ");
            int[] arr = new int[m];

            for(int i = 0; i < m; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            int ans = solve(arr);
            System.out.println(ans);
        }
    }
    private static int solve(int[] arr) {
        int n = arr.length;
        int[] ans = new int[]{0};
        int[] res = helper(0, n - 1, arr, ans);
        if(isSorted(res, true))
            return ans[0];
        return -1;
    }
    private static int[] helper(int start, int end, int[] arr, int[] ans) {
        if(start == end) {
            return new int[]{arr[start]};
        }
        int mid = start + (end - start) / 2;
        int[] left = helper(start, mid, arr, ans);
        int[] right = helper(mid + 1, end, arr, ans);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < left.length; i++) {
            min = Math.min(right[i], min);
            max = Math.max(left[i], max);
        }
        if(max > min) {
            ans[0]++;
            return swap(left, right);
        }
        return swap(right, left);
    }
    private static boolean isSorted(int[] arr, boolean ascending) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
           if(ascending) {
               if(arr[i] > arr[i + 1]) {
                   return false;
               }
           }else {
               if(arr[i] < arr[i + 1]) {
                   return false;
               }
           }
        }
        return true;
    }
    private static int[] swap(int[] a, int[] b) {
        int[] res = new int[2 * a.length];
        for(int i = 0; i < a.length; i++) {
            res[i] = b[i];
            res[i + a.length] = a[i];
        }
        return res;
    }
}
