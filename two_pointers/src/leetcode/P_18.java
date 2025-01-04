package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 18. 4Sum
public class P_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int start = j + 1, end = n - 1;
                long newTarget = (long)target - (long)nums[i] - (long)nums[j];
                while (start < end) {

                    if (nums[start] + nums[end] < newTarget) {
                        start++;
                    } else if (nums[start] + nums[end] > newTarget) {
                        end--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        int tempIndex1 = start, tempIndex2 = end;
                        while (start < end && nums[start] == nums[tempIndex1]) start++;
                        while (start < end && nums[end] == nums[tempIndex2]) end--;
                    }
                }
                while (j + 1 < n && nums[j] == nums[j + 1]) j++;
            }
            while (i + 1 < n && nums[i] == nums[i + 1]) i++;
        }

        return result;
    }


}
