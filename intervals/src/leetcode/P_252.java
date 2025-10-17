package leetcode;

import java.util.List;

/**
 * 252. Meeting Rooms
 */
class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class P_252 {

    public boolean canAttendMeetings(List<Interval> intervals) {

        if (intervals.isEmpty() || intervals.size() == 1) return true;

        int prevStart = Integer.MAX_VALUE;
        int prevEnd = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.size(); i++) {
            int currentStart = intervals.get(i).start;
            if (currentStart >= prevStart && currentStart < prevEnd) {
                return false;
            }
            prevStart = currentStart;
            prevEnd = intervals.get(i).end;
        }

        return true;
    }
}
