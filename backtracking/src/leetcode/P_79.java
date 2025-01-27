package leetcode;

import java.util.Arrays;

/**
 * 79. Word Search
 * <p>
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
public class P_79 {

    public static boolean wordSearch(char[][] grid, String word) {
        int n = grid.length;
        int m = grid[0].length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (depthFirstSearch(row, col, word, 0, grid)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean depthFirstSearch(int row, int col, String word, int index, char[][] grid) {
        if (word.length() == index) {
            return true;
        }

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || (grid[row][col] != word.charAt(index))) {
            return false;
        }

        boolean result = false;

        char temp = grid[row][col];
        grid[row][col] = '*';

        int[][] offsets = {
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        for (int[] offset : offsets) {
            int rowOffset = offset[0];
            int colOffset = offset[1];

            System.out.println("index = " + index + ", row = " + row + ", col = " + col);
            System.out.println(Arrays.toString(grid));

            result = depthFirstSearch(row + rowOffset, col + colOffset, word, index + 1, grid);

            System.out.println("================================================");

            if (result) {
                break;
            }
        }

        grid[row][col] = temp;

        return result;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'e', 'd', 'x', 'i', 'w'},
                {'p', 'u', 'f', 'm', 'q'},
                {'i', 'c', 'a', 't', 'e'},
                {'m', 'a', 'l', 'c', 'a'},
                {'j', 't', 'i', 'v', 'e'}
        };

        wordSearch(grid, "educative");
    }
}
