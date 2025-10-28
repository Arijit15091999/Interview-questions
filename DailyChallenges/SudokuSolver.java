import java.util.*;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        char[][] copy = copy(board);
        HashSet<Character>[] visited = markVisited(board);
        helper(0, 0, copy, visited);
    }
    private char[][] copy(char[][] arr) {
        int m = arr.length, n = arr[0].length;
        char[][] copy = new char[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }
    private boolean helper(
            int row,
            int col,
            char[][] board,
            HashSet<Character>[] visited
    ) {
        if(col == 9) {
            return helper(row + 1, 0, board, visited);
        }
        if(row == 9) {
            return true;
        }
        char ch = board[row][col];
        if(ch != '.') {
            return helper(row, col + 1, board, visited);
        }else {
            for(int i = 1; i <= 9; i++) {
                char c = String.valueOf(i).charAt(0);
                if(isValidMove(c, row, col, visited, board)) {
                    board[row][col] = c;
                    visited[getIndex(row, col)].add(c);
                    boolean ans = helper(row, col + 1, board, visited);
                    if(ans) return true;
                    board[row][col] = '.';
                    visited[getIndex(row, col)].remove(c);
                }
            }
        }
        return false;
    }
    private boolean isValidMove(
            char ch,
            int row,
            int col,
            HashSet<Character>[] visited,
            char[][] board
    ) {
        int index = getIndex(row, col);
        if(visited[index].contains(ch)) {
            return false;
        }
        // left side row
        int i = row, j = col;
        while(j >= 0) {
            if(board[i][j] == ch) {
                return false;
            }
            j--;
        }
        //right side row
        j = col;
        while(j < 9) {
            if(board[i][j] == ch) {
                return false;
            }
            j++;
        }
        //upper side
        i = row;
        j = col;
        while(i >= 0) {
            if(board[i][j] == ch) return false;
            i--;
        }
        //lower side
        i = row;
        j = col;
        while(i < 9) {
            if(board[i][j] == ch) return false;
            i++;
        }

        return true;
    }
    private HashSet<Character>[] markVisited(char[][] arr) {
        HashSet<Character>[] visited = new HashSet[9];
        for(int i = 0; i < 9; i++) {
            visited[i] = new HashSet<>();
        }
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char ch = arr[i][j];
                int row = i / 3, col = j / 3;
                int index = 3 * row + col;
                visited[index].add(ch);
            }
        }

        return visited;
    }
    private int getIndex(int row, int col) {
        row /= 3;
        col /= 3;
        return 3 * row + col;
    }
}
