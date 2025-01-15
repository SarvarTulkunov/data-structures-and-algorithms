package leetcode;

/**
 * 463. Island Perimeter
 */
public class P_463 {

    public static int islandPerimeter(int[][] grid) {

        int perimeter = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    perimeter += 4;

                    if (row - 1 >= 0) {
                        if(grid[row - 1][col] == 1) perimeter--;
                    }
                    if (row + 1 < rows) {
                        if (grid[row + 1][col] == 1) perimeter--;
                    }
                    if (col - 1 >= 0) {
                        if (grid[row][col - 1] == 1) perimeter--;
                    }
                    if (col + 1 < cols) {
                        if (grid[row][col + 1] == 1) perimeter--;
                    }

                }

            }
        }

        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {0 , 1, 0, 0},
                {1 , 1, 1, 0},
                {0 , 1, 0, 0},
                {1 , 1, 0, 0}
        };

        int[][] grid2 = {
                {1}
        };

        System.out.println(islandPerimeter(grid1));
        System.out.println(islandPerimeter(grid2));

    }
}
