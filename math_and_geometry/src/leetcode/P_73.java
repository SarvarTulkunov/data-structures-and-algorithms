package leetcode;

/**
 * 73. Set Matrix Zeroes
 */
public class P_73 {

    public static void setZeroes(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        boolean topMostRowHasZero = false;
        boolean leftMostColHasZero = false;

        // Check if first row has a zero
        for (int c = 0; c < COLS; c++) {
            if (matrix[0][c] == 0) {
                topMostRowHasZero = true;
                break;
            }
        }

        // Check if first column has a zero
        for (int r = 0; r < ROWS; r++) {
            if (matrix[r][0] == 0) {
                leftMostColHasZero = true;
                break;
            }
        }

        // Use first row/column as markers
        for (int r = 1; r < ROWS; r++) {
            for (int c = 1; c < COLS; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }

        // Set cells to zero based on markers (skip first row/col for now)
        for (int r = 1; r < ROWS; r++) {
            for (int c = 1; c < COLS; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // Zero out the first row if needed
        if (topMostRowHasZero) {
            for (int c = 0; c < COLS; c++) {
                matrix[0][c] = 0;
            }
        }

        // Zero out the first column if needed
        if (leftMostColHasZero) {
            for (int r = 0; r < ROWS; r++) {
                matrix[r][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        setZeroes(new int[][]{{0, 1}, {1, 1}});
    }
}
