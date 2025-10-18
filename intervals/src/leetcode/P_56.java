package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 */
public class P_56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int[] interval : intervals) {
            int[] lastInterval = res.get(res.size() - 1);
            int lastEnd = lastInterval[1];

            if (lastEnd >= interval[0]) {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            } else {
                res.add(interval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
