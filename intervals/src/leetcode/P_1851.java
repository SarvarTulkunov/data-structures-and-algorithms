package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1851. Minimum Interval to Include Each Query
 */
public class P_1851 {

    public static int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Store queries with their original indices
        int n = queries.length;
        int[][] queriesWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            queriesWithIndex[i][0] = queries[i];
            queriesWithIndex[i][1] = i;
        }
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(a -> a[0]));

        int[] res = new int[n];
        Arrays.fill(res, -1);

        // Priority queue: [interval_end, interval_length]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int j = 0;

        for (int[] q : queriesWithIndex) {
            int query = q[0];
            int idx = q[1];

            // Add all intervals whose start <= current query
            while (j < intervals.length && intervals[j][0] <= query) {
                int start = intervals[j][0];
                int end = intervals[j][1];
                pq.offer(new int[]{end, end - start + 1});
                j++;
            }

            // Remove intervals that end < query
            while (!pq.isEmpty() && pq.peek()[0] < query) {
                pq.poll();
            }

            // Top of heap has smallest length interval that includes query
            if (!pq.isEmpty()) {
                res[idx] = pq.peek()[1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        minInterval(new int[][]{{1, 3}, {2, 3}, {3, 7}, {6, 6}}, new int[]{2, 3, 1, 7, 6, 8});
    }
}
