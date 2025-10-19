package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. Non-overlapping Intervals
 */
public class P_435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int prevEnd = intervals[0][1], count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1];
            } else {
                prevEnd = Math.min(prevEnd, intervals[i][1]);
                count++;
            }
        }

        return count;
    }
}
