import java.util.Scanner;

public class Codeforces82A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = 0;
        String[] names = new String[]{ "Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        while(n > 5 * (int)Math.pow(2,t)) {
            n -= 5 * (int)Math.pow(2,t);
            t++;
        }
        int index = (n - 1) / (int)Math.pow(2, t);
        System.out.println(names[index]);
    }
}
