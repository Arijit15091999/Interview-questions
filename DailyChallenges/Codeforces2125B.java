import java.util.Scanner;

public class Codeforces2125B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t-- > 0) {
            String[] str = sc.nextLine().trim().split(" ");
            long a = Long.parseLong(str[0]);
            long b = Long.parseLong(str[1]);
            long k = Long.parseLong(str[2]);

            long gcd = gcd(a, b);

            if(Math.max(a / gcd, b / gcd) > k) {
                System.out.println(2);
            }else {
                System.out.println(1);
            }
        }
    }
    private static long gcd(long a, long b) {
        if(b == 0) {
            return a;
        }
        if(b > a) {
            return gcd(b, a);
        }
        return gcd(b, a % b);
    }
}
