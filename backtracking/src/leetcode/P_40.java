package leetcode;

import java.util.*;

/**
 * 40. Combination Sum II
 */
public class P_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        int sum = 0;

        Arrays.sort(candidates);

        dfs(res, subset, candidates, 0, sum, target);

        return new ArrayList<>(res);
    }

    public static void dfs(List<List<Integer>> res, List<Integer> subset, int[] nums, int index, int sum, int target) {

        if (sum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }

        if (index >= nums.length || sum > target) {
            return;
        }

        subset.add(nums[index]);
        dfs(res, subset, nums, index + 1, sum + nums[index], target);
        subset.remove(subset.size() - 1);

        while (index + 1 < nums.length && nums[index + 1] == nums[index]) {
            index++;
        }
        
        dfs(res, subset, nums, index + 1, sum, target);
    }

}
