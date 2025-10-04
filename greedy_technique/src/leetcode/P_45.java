package leetcode;

/**
 * 45. Jump Game II
 */
public class P_45 {

    public static int jump(int[] nums) {
        int l = 0, r = 0;
        int minSteps = 0;
        while (r < nums.length - 1) {
            int maxReachableIndex = l;
            for (int i = l; i <= r; i++) {
                maxReachableIndex = Math.max(maxReachableIndex, i + nums[i]);
            }
            l = r + 1;
            r = maxReachableIndex;
            minSteps++;
        }
        return minSteps;
    }

}
