package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 90. Subsets II
 */
public class P_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(nums);
        dfs(nums, 0, subset, res);
        
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(nums, index + 1, subset, res);
        while (index < nums.length - 1 && nums[index + 1] == nums[index]) {
            index++;
        }
        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, subset, res);
    }
}
