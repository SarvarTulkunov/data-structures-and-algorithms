package leetcode;

/**
 * 55. Jump Game
 */
public class P_55 {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int currentTargetIndex = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= currentTargetIndex) {
                currentTargetIndex = i;
            }
        }

        // Replace this placeholder return statement with your code
        return currentTargetIndex == 0;
    }
    
}
