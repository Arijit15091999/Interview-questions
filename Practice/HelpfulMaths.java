import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();

        String[] summands = exp.split("\\+");
        Arrays.sort(summands, (a, b) -> {
            int ch1 = Integer.parseInt(a);
            int ch2 = Integer.parseInt(b);
            return ch1 - ch2;
        });

        String newExp = String.join("+", summands);

        System.out.println(newExp);
    }
}
