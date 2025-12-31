import java.util.Arrays;
import java.util.Scanner;

public class GravityFlip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        printArray(arr);
    }
    private static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1)
                System.out.print(arr[i]);
            else {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
