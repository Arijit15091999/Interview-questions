import java.util.Scanner;

public class NextRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        sc.nextLine();

        int[] scores = new int[n];

        for(int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.println(getCount(scores, k));
    }
    private static int getCount(int[] scores, int k) {
        int cutOff = scores[k - 1];
        int count = 0;
        for(int score : scores) {
            if(score >= cutOff && score > 0) {
                count++;
            }
            if(score < cutOff) break;
        }
        return count;
    }
}
