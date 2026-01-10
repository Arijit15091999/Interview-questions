import java.util.Scanner;

public class Codeforces2175B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            sc.nextLine();

            int[] ans = solve(n, l, r);
            for(int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
    public static int[] solve(int n, int l, int r) {
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int sum = 0;
        for(int i = l; i < r; i++) {
            sum ^= arr[i - 1];
        }
        arr[r-1] = sum;
        return arr;
    }
}
