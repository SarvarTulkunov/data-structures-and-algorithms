package leetcode;

public class P_153 {

    public int findMin(int[] nums) {

        int left = 0, right = nums.length - 1;
        int mid;

        while (left < right) {
            mid = (right - left) / 2 + left;

            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }

}
