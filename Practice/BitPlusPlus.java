import java.util.Scanner;

public class BitPlusPlus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {
            String instruction = sc.nextLine();
            x = execute(instruction, x);
        }
        System.out.println(x);
    }
    private static int execute(String instruction, int x) {
        if(instruction.contains("++")) {
            x++;
        }
        if(instruction.contains("--")) {
            x--;
        }
        return x;
    }
}
