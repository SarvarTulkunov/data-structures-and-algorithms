package leetcode;

/**
 * 1913. Maximum Product Difference Between Two Pairs
 */
public class P_1913 {

    public int maxProductDifference(int[] nums) {

        int max1 = -1, max2 = -1, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int n : nums) {

            if (n >= max1) {
                max2 = max1;
                max1 = n;
            } else if (n < max1 && n > max2) {
                max2 = n;
            }

            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n > min1 && n < min2) {
                min2 = n;
            }
        }

        return max1 * max2 - min1 * min2;
    }

}
