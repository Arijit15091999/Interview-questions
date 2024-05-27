import java.util.*;

public class LeetCode1219 {
    public static void main(String[] args) {
//        [[0,6,0],[5,8,7],[0,9,0]]
        System.out.println(getMaximumGold(new int[][] {
                {0,6,0},
                {5,8,7},
                {0,9,0}
        }));
    }

    private final static int[] delRow = {0, -1, 0, 1};
    private final static int[] delCol = {-1, 0, 1, 0};

    public static int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = Integer.MIN_VALUE;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) {
                    res = Math.max(res, dfs(i , j, grid, new boolean[m][n]));
                }
            }
        }

        return res;
    }

    private static int dfs(int row, int col, int[][] arr, boolean[][] visited){
        if(visited[row][col] || arr[row][col] == 0) {
            return 0;
        }
        visited[row][col] = true;
        int res = arr[row][col];

        for(int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if(isValidIndex(newRow, newCol, arr)){
                res = Math.max(res , res + dfs(newRow, newCol, arr, visited));
            }
        }

        return res;
    }

    private static boolean isValidIndex(int row, int col, int[][] arr) {
        return row >= 0 && col >= 0 && row < arr.length && col < arr[0].length;
    }
}
