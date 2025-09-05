package leetcode;

import java.util.Arrays;

/**
 * 130. Surrounded Regions
 */
public class P_130 {

    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(board, 0, i, n, m);
            dfs(board, n - 1, i, n, m);
        }

        for (int i = 0; i < n; i++) {
            dfs(board, i, 0, n, m);
            dfs(board, i, m - 1, n, m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private static void dfs(char[][] board, int r, int c, int R, int C) {

        if (r < 0 || r >= R || c < 0 || c >= C || board[r][c] != 'O') {
            return;
        }

        board[r][c] = 'T';

        for (int[] dir : DIRS) {
            int row = r + dir[0];
            int col = c + dir[1];

            dfs(board, row, col, R, C);
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'X', 'O'}
        };

        char[][] board2 = new char[][]{
                {'O', 'X', 'O'},
                {'X', 'O', 'X'},
                {'O', 'X', 'O'}
        };

        solve(board2);

        System.out.println(Arrays.deepToString(board));
    }
}
