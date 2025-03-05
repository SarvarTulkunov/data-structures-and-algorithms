package leetcode;


/**
 * 1929. Concatenation of Array
 */
public class P_1929 {

    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2 * nums.length];

        int k = nums.length;

        for (int i = 0; i < k; i++) {
            ans[i] = nums[i];
            ans[i + k] = nums[i];
        }

        return ans;
    }

}
