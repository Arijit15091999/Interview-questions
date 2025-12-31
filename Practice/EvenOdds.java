import java.util.*;
public class EvenOdds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        System.out.println(getNumber(n, k));
    }
    private static long getNumber(long n, long k) {
        boolean even = n % 2 == 0;
        long partition = even ?  n / 2 : n / 2 + 1;

        if(k <= partition) {
            return 1 + (k - 1) * 2;
        }
        return 2 + (k - partition - 1) * 2;
    }
}
