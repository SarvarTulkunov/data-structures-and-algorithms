package leetcode;

/**
 * 200. Number of Islands
 *
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 *
 * Output: 1
 */
public class P_200 {

    public static int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int numberOfIslands = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    numberOfIslands++;
                    dfs(grid, rows, cols, row, col);
                }
            }
        }

        return numberOfIslands;
    }

    public static void dfs(char[][] grid, int rowNum, int colNum, int row, int col) {
        if (row < 0 || row > rowNum - 1 || col < 0 || col > colNum - 1) {
            return;
        }

        if (grid[row][col] == '1') {
            grid[row][col] = '0';
            dfs(grid, rowNum, colNum, row + 1, col);
            dfs(grid, rowNum, colNum, row - 1, col);
            dfs(grid, rowNum, colNum, row, col - 1);
            dfs(grid, rowNum, colNum, row, col + 1);
        }

    }

    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid2));
    }

}
