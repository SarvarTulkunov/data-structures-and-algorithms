package leetcode;

public class P_74 {
    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix[0].length - 1;

        for (int[] row : matrix) {
            if (row[0] == target || row[m] == target) return true;

            if (target > row[0] && target < row[m]) {
                int l = 0, r = m;
                int mid;

                while (l <= r) {
                    mid = (r - l) / 2 + l;

                    if (row[mid] > target) {
                        r--;
                    } else if (row[mid] < target) {
                        l++;
                    } else {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] row1 = new int[]{1, 3, 5, 7};
        int[] row2 = new int[]{10, 11, 16, 20};
        int[] row3 = new int[]{23, 30, 34, 60};
        int[][] grid = new int[][]{row1, row2, row3};

        System.out.println(searchMatrix(grid, 13));
    }
}
