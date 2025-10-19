package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class P_253 {

    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        for (Interval interval : intervals) {
            startTimes.add(interval.start);
            endTimes.add(interval.end);
        }

        startTimes.sort(Comparator.comparingInt(a -> a));
        endTimes.sort(Comparator.comparingInt(a -> a));

        int res = 0, count = 0;
        int s = 0, e = 0;

        while (s < startTimes.size()) {
            if (startTimes.get(s) < endTimes.get(e)) {
                count++;
                s++;
            } else {
                count--;
                e++;
            }
            res = Math.max(res, count);
        }

        return res;
    }
}
