import java.util.*;
public class Team {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] problems = new int[n][3];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                problems[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        System.out.println(getCount(problems));
    }

    private static int getCount(int[][] arr) {
        int count = 0;

        for(int[] a : arr) {
            int tempCount = 0;
            for(int num : a) {
                if(num == 1) {
                    tempCount++;
                }
            }
            if(tempCount >= 2) {
                count++;
            }
        }
        return count;
    }
}
