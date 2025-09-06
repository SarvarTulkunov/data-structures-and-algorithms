package leetcode;

import java.util.*;

/**
 * 207. Course Schedule
 */
public class P_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            preMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, preMap, visited)) return false;
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visited) {
        if (visited.contains(course)) return false;

        if (preMap.get(course).isEmpty()) {
            return true;
        }

        visited.add(course);
        for (Integer pre : preMap.get(course)) {
            if (!dfs(pre, preMap, visited)) return false;
        }
        visited.remove(course);
        preMap.get(course).clear();
        return true;
    }
}
