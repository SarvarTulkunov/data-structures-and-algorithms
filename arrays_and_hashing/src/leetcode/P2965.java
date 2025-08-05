package leetcode;

import java.util.Arrays;

public class P2965 {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int nSquared = n * n;
        long actualSum = 0;
        long actualSumSquares = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                actualSum += grid[i][j];
                actualSumSquares += grid[i][j] * grid[i][j];
            }
        }
        long expectedSum = (long) nSquared * (nSquared + 1) / 2;
        long expectedSumSquares = (long) nSquared * (nSquared + 1) * (2 * nSquared + 1) / 6;
        long aMinusB = actualSum - expectedSum;
        long aPlusB = (actualSumSquares - expectedSumSquares) / aMinusB;

        long a = (aMinusB + aPlusB) / 2;
        long b = aPlusB - a;
        return new int[]{(int) a, (int) b};
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0] = new int[]{9, 1, 7};
        grid[1] = new int[]{8, 9, 2};
        grid[2] = new int[]{3, 4, 6};

        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
    }
}
