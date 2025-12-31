import java.util.Scanner;

public class BeautifulMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[5][5];
        int[] pos = new int[2];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] != 0) {
                    pos = new int[] {i, j};
                }
            }
            sc.nextLine();
        }
        int moves = 0;
        // get the displacement
        moves = Math.abs(pos[0] - 2) + Math.abs(pos[1] - 2);

        System.out.println(moves);
    }
}
