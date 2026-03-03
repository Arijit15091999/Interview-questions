import java.util.Arrays;
import java.util.Scanner;

public class Codeforces1902C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String[] line = sc.nextLine().trim().split(" ");
            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }

            Arrays.sort(arr);
            int max = arr[n - 1];

            int gcd = 0;

            for(int i = 0; i < n - 1; i++) {
                gcd = gcd(gcd, arr[i + 1] - arr[i]);
            }

            long maxOps = 0;
            int j = arr[n - 1];
            for(int i = n - 1; i >= 0; i--) {
                if(j == arr[i]) j--;
                else {
                    if((max - j) % gcd == 0) break;
                }
            }

            gcd = gcd(gcd, max - j);

            maxOps += (max - j) / gcd;

            for(int i = 0; i < n; i++) {
                maxOps += (max - arr[i]) / gcd;
            }

            System.out.println(maxOps);
        }
    }
    private static int gcd(int a, int b) {
        if(b > a) {
            return gcd(b, a);
        }
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
