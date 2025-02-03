package leetcode;

/**
 * 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
 * <p>
 * You are given an array of integers nums. Return the length of the longest
 * subarray of nums which is either strictly increasing or strictly decreasing.
 */
public class P_3105 {

    public static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length, ans = 0;
        int inc = 1, dec = 1;

        if (n == 1) return 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            } else if (nums[i] < nums[i - 1]) {
                inc = 1;
                dec++;
            } else {
                inc = dec = 1;
            }
            ans = Math.max(ans, Math.max(inc, dec));
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(longestMonotonicSubarray(new int[]{1, 4, 5, 3, 2, 1, 0}));
    }
}
