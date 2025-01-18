package leetcode;

/**
 * 695. Max Area of Island
 */
public class P_695 {

    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    // Start DFS and calculate area
                    maxArea = Math.max(maxArea, dfs(grid, row, col));
                }
            }
        }

        return maxArea;
    }

    private static int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        int area = 1; // Current cell
        area += dfs(grid, row + 1, col); // Down
        area += dfs(grid, row - 1, col); // Up
        area += dfs(grid, row, col + 1); // Right
        area += dfs(grid, row, col - 1); // Left

        return area;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 0, 1},
                {0, 1, 0, 0, 1}
        };

        System.out.println(maxAreaOfIsland(grid));
    }
}
