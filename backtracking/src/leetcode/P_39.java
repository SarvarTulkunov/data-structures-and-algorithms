package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * <p>
 * Input:
 * nums = [2,5,6,9]
 * target = 9
 * <p>
 * Output: [[2,2,5],[9]]
 */
public class P_39 {

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        int sum = 0;

        dfs(res, subset, nums, 0, sum, target);

        return res;
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
        dfs(res, subset, nums, index, sum + nums[index], target);
        subset.remove(subset.size() - 1);
        dfs(res, subset, nums, index + 1, sum, target);
    }


    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 9};
        int target = 9;

        System.out.println(combinationSum(nums, target));
    }
}
