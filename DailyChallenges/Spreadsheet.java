import java.util.*;

class Spreadsheet {
    private int[][] sheet;
    private int rows;
    private int columns;

    public Spreadsheet(int rows) {
        this.rows = rows;
        this.columns = 26;
        this.sheet = new int[rows][26];
        for(int[] row : sheet) {
            Arrays.fill(row, 0);
        }
    }

    public void setCell(String cell, int value) {
        int[] coordinate = getRowAndCol(cell);
        int row = coordinate[0];
        if(row == -1) {
            return;
        }
        int column = coordinate[1];

        this.sheet[row][column] = value;
    }

    public void resetCell(String cell) {
        this.setCell(cell, 0);
    }

    public int getValue(String formula) {
        String[] cells = formula.substring(1).split("\\+");
        int[] coordinate1 = getRowAndCol(cells[0]);
        int[] coordinate2 = getRowAndCol(cells[1]);

        int row1 = coordinate1[0], col1 = coordinate1[1];
        int row2 = coordinate2[0], col2 = coordinate2[1];

        int value1 = isValidRowAndColum(row1, col1) ? this.sheet[row1][col1] : 0;
        int value2 = isValidRowAndColum(row2, col2) ? this.sheet[row2][col2] : 0;

        if(row1 == -1) {
            value1 = col1;
        }
        if(row2 == -1) {
            value2 = col2;
        }
        return value1 + value2;
    }
    private boolean isValidRowAndColum(int row, int col) {
        return row >= 0 && row < this.rows && col >= 0 && col < this.columns;
    }
    private int[] getRowAndCol(String cell) {
        int column = Integer.parseInt(cell.charAt(0) + "");
        String temp = cell.substring(1);
        int row = temp.length() == 0 ? -1 : Integer.parseInt(temp);

        return new int[]{row, column};
    }
}