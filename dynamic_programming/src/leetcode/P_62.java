package leetcode;

import java.math.BigInteger;

/**
 * 62. Unique Paths
 */
public class P_62 {

    public int uniquePaths(int m, int n) {
        int totalSteps = m + n - 2;
        int stepsDown = Math.min(m - 1, n - 1); // pick smaller to reduce iterations

        long result = 1;
        for (int i = 1; i <= stepsDown; i++) {
            result = result * (totalSteps - stepsDown + i) / i;
        }

        return (int) result;
    }

}
