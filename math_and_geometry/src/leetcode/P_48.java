package leetcode;

/**
 * 48. Rotate Image
 */
public class P_48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n / 2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][n - 1 - col];
                matrix[row][n - 1 - col] = temp;
            }
        }
    }
}
