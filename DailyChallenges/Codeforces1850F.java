import java.util.Scanner;

public class Codeforces1850F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            int[] hopCount = new int[n + 1];
            String[] line = sc.nextLine().trim().split(" ");

            for(int i = 0; i < n; i++) {
                int freq = Integer.parseInt(line[i]);
                if(freq <= n)
                    hopCount[freq]++;
            }

            int[] freqCount = new int[n + 1];
            int ans = 0;

            for(int i = 1; i <= n; i++) {
                int hop = hopCount[i];
                if(hop == 0) continue;
                for(int j = i; j <= n; j+=i) {
                    freqCount[j] += hop;
                    ans = Math.max(ans, freqCount[j]);
                }
            }
            System.out.println(ans);
        }
    }
}
