import java.util.*;
public class Codeforces1917B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();

            long ans = solve(str, n);
            System.out.println(ans);
        }
    }
    private static long solve(String str, int n) {
        int[] set = new int[26];
        int index = 0;
        long ans = 0;
        while(index < n) {
            char ch = str.charAt(index);
            if(set[ch - 'a'] == 0) {
                set[ch - 'a'] = 1;
                ans += n - index;
            }
            index++;
        }
        return ans;
    }
}
