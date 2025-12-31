import java.util.Scanner;

public final class Codeforces327A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] line = sc.nextLine().trim().split(" ");
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        solve(arr);
    }
    private static void solve(int[] arr){
        int n = arr.length;
        int[] b = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            count += (arr[i] == 1) ? 1 : 0;
;           b[i] = (arr[i] == 0) ? 1 : -1;
        }

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i = 0; i < n; i++) {
            currSum += b[i];
            maxSum = Math.max(maxSum, currSum);
            currSum = Math.max(currSum, 0);
        }
        System.out.println(count + maxSum);
    }
}
