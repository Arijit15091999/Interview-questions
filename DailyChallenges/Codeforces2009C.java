import java.util.Scanner;

public class Codeforces2009C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            sc.nextLine();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k = sc.nextInt();

            int ans = solve(x, y, k);
            System.out.println(ans);
        }
    }
    private static int solve(int x, int y, int k) throws ArithmeticException {
//        int xSteps = (x + k - 1) / k;
//        int ySteps = (y + k - 1) / k;

        int xSteps = (int)Math.ceil((double)x / k);
        int ySteps = (int)Math.ceil((double)y / k);

        if (ySteps > xSteps) {
            return 2 * ySteps;
        }
        return 2 * xSteps - 1;
    }
}
