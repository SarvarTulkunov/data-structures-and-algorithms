package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 */
public class P_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length;
        int top = 0, bottom = matrix.length;

        while (left < right && top < bottom) {

            // get every i in the top row
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // get every i  in the right column
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right - 1]);
            }
            right--;


            if (!(left < right && top < bottom)) {
                break;
            }

            // get every i in the bottom row
            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[bottom - 1][i]);
            }
            bottom--;

            // get every i in the left column
            for (int i = bottom - 1; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }
}
