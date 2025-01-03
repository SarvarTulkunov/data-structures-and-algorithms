package leetcode;

import java.util.Arrays;

// 1984. Minimum Difference Between Highest and Lowest of K Scores
public class P_1984 {

    public static int minimumDifference(int[] nums, int k) {

        if (k == 1) return 0;

        Arrays.sort(nums);

        int left = 0, right = 0, res = Integer.MAX_VALUE;

        // 1- way
//        while (right < nums.length){
//            if(right - left + 1 == k){
//                int current = nums[right] - nums[left];
//                res = Math.min(res, current);
//                left++;
//            }
//            right++;
//        }

        // 2 - way (Optimized)
        for (int i = 0; i <= nums.length - k; i++) {
            int current = nums[i + k - 1] - nums[i];
            if (res > current) res = current;
        }

        return res;
    }

}
