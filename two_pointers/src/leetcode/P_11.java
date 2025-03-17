package leetcode;

/**
 * 11. Container With Most Water
 */
public class P_11 {

    public int maxArea(int[] height) {

        int res = 0, left = 0, right = height.length - 1;

        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
