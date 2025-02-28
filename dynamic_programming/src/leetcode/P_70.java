package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. Climbing Stairs
 */
public class P_70 {

    private Map<Integer, Integer> map = new HashMap<>();

    // top-down
    public int climbStairs(int n) {

        if (n <= 1) return 1;
        if (n == 2) return 2;

        int res = climbStairs(n - 1) + climbStairs(n - 2);

        map.put(res, map.getOrDefault(res, 0) + 1);

        return res;
    }

    // bottom-up
    public int climbStairsSolution2(int n) {
        if(n == 1) return 1;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
