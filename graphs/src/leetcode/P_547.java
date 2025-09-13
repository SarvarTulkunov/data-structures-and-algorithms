package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 547. Number of Provinces
 */
public class P_547 {

    /**
     * Solution 1 - DFS
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        // Use Set to avoid duplicate edges and remove O(n) contains() cost
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }

        // Build adjacency list in O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int res = 0;
        boolean[] visited = new boolean[n];

        // DFS on each unvisited node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i);
                res++;
            }
        }

        return res;
    }

    private void dfs(List<Set<Integer>> adj, boolean[] visit, int node) {
        visit[node] = true;
        for (int nei : adj.get(node)) {
            if (!visit[nei]) {
                dfs(adj, visit, nei);
            }
        }
    }

    /**
     * Solution 2 - DFS (Optimized)
     */
    public int findCircleNum2(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int provinces = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                dfs(i, isConnected, visited);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int city, int[][] isConnected, Set<Integer> visited) {
        visited.add(city);
        for (int cur = 0; cur < isConnected[city].length; cur++) {
            int connected = isConnected[city][cur];
            if (connected == 1 && !visited.contains(cur)) {
                dfs(cur, isConnected, visited);
            }
        }
    }

}
