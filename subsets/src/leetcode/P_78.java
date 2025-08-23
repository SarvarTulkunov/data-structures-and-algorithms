package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> res){
        if(index >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(nums, index + 1, subset, res);
        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, subset, res);
    }
}
