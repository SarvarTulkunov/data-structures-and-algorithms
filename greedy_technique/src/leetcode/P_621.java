package leetcode;

import java.util.*;

/**
 * 621. Task Scheduler
 */
public class P_621 {

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        Arrays.sort(count);

        int max_val = count[25] - 1;
        int idle_spots = max_val * n;

        for (int i = 24; i >= 0; i--) {
            idle_spots -= Math.min(count[i], max_val);
        }

        return idle_spots > 0 ? idle_spots + tasks.length : tasks.length;
    }
}
