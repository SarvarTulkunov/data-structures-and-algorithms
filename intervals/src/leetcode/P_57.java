package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 */
public class P_57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // Add all intervals that end before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge all overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // merged interval

        // Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert List<int[]> → int[][]
        return result.toArray(new int[result.size()][]);
    }

}
