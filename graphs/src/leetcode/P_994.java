package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 994. Rotting Oranges
 */
public class P_994 {

    public static int orangesRotting(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: Initialize queue with rotten oranges & count fresh ones
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // If no fresh oranges
        if (fresh == 0) return 0;

        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int minutes = 0;

        // Step 2: BFS
        while (!q.isEmpty()) {
            int size = q.size();
            boolean spread = false; // Track if any orange rotted this minute

            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int row = node[0], col = node[1];

                for (int[] dir : dirs) {
                    int r = row + dir[0], c = col + dir[1];

                    if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1) {
                        grid[r][c] = 2; // rot it
                        q.offer(new int[]{r, c});
                        fresh--;
                        spread = true;
                    }
                }
            }

            if (spread) minutes++; // Only increment if rotting occurred
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 1, 0}, {0, 1, 1}, {0, 1, 2}};
        int res = orangesRotting(grid);
        System.out.println(res);
    }
}
