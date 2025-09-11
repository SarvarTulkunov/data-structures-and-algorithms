package leetcode;

import java.util.*;

public class P_178 {

    public boolean validTree(int n, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        return dfs(map, visited, -1, 0) && visited.size() == n;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int prev, int curr) {
        if (visited.contains(curr)) {
            return false;
        }

        visited.add(curr);

        if (map.containsKey(curr)) {
            for (int neighbour : map.get(curr)) {
                if (neighbour == prev) {
                    continue;
                }

                if (!dfs(map, visited, curr, neighbour)) {
                    return false;
                }
            }
        }

        return true;
    }

}
