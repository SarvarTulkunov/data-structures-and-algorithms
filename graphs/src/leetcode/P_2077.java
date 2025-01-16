package leetcode;

import java.util.*;

/**
 * 2077. Paths in Maze That Lead to Same Room
 */
public class P_2077 {

    public static int numberOfPaths(int n, int[][] corridors) {
        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        int cycles = 0;

        for (int[] corridor : corridors) {
            int room1 = corridor[0];
            int room2 = corridor[1];

            neighbors.putIfAbsent(room1, new HashSet<>());
            neighbors.putIfAbsent(room2, new HashSet<>());
            neighbors.get(room1).add(room2);
            neighbors.get(room2).add(room1);

            cycles += intersectionLength(neighbors.get(room1), neighbors.get(room2));
        }

        return cycles;
    }

    private static int intersectionLength(Set<Integer> set1, Set<Integer> set2) {
        int count = 0;
        for (int element : set1) {
            if (set2.contains(element)) {
                count++;
            }
        }
        return count;
    }

}
