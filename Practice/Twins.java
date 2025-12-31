import java.util.*;
public class Twins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        System.out.println(findCoins(arr, sum));
    }
    private static int findCoins(int[] arr, int sum) {
        int currentSum = 0, remainingSum = sum, index = arr.length - 1;
        int count = 0;
        while(index >= 0 && currentSum <= remainingSum) {
            currentSum += arr[index];
            remainingSum -= arr[index];
            index--;
            count++;
        }
        return count;
    }
}
