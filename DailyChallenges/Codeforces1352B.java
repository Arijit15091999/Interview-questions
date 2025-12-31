import java.util.Scanner;

public final class Codeforces1352B{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            sc.nextLine();
            int n = sc.nextInt();
            int k = sc.nextInt();

            solve(n, k);
        }
    }
    private static void solve(int n, int k) {
        int n1 = n - (k - 1);
        boolean ans = false;
        if(n1 > 0 && n1 % 2 == 1) {
            System.out.println("yes");
            ans = true;
            for(int i = 0; i < k - 1; i++) {
                System.out.print("1 ");
            }
            System.out.println(n1);
        }

        int n2 = n - (k - 1) * 2;

        if(!ans && n2 > 0 && n2 % 2 == 0) {
            System.out.println("yes");
            ans = true;
            for(int i = 0; i < k - 1; i++) {
                System.out.print("2 ");
            }
            System.out.println(n2);
        }
        if(ans) return;
        System.out.println("No");
    }
}
