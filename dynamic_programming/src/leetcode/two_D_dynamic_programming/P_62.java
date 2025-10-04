package leetcode.two_D_dynamic_programming;

/**
 * 62. Unique Paths
 */
public class P_62 {

    /**
     * Bottom Up
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];
    }

    /**
     * Math
     */
    public int uniquePaths2(int m, int n) {
        int totalSteps = m + n - 2;
        int stepsDown = Math.min(m - 1, n - 1); // pick smaller to reduce iterations

        long result = 1;
        for (int i = 1; i <= stepsDown; i++) {
            result = result * (totalSteps - stepsDown + i) / i;
        }

        return (int) result;
    }

}
