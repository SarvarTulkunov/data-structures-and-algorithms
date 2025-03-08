package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 75. Sort Colors
 */
public class P_75 {

    public void sortColors(int[] nums) {
        int[] freq = new int[3];

        for (int num : nums) {
            freq[num]++;
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (freq[i]-- > 0) {
                nums[index++] = i;
            }
        }
    }

    /**
     * Dutch National Flag Algorithm
     */
/*
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
*/

}
