package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1791. Find Center of Star Graph
 */
public class P_1791 {

    public static int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2}, {2, 3}, {4, 2}
        };

        System.out.println(findCenter(edges));
    }
}
