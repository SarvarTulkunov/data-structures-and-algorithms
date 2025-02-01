package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * <p>
 * You may return the answer in any order.
 */
public class P_77 {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(res, subset, 1, n, k);

        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> subset, int i, int n, int k) {

        if (subset.size() == k) {
            res.add(new ArrayList<>(subset));
            return;
        }

        while (i <= n) {
            subset.add(i);
            dfs(res, subset, i + 1, n, k);
            subset.remove(subset.size() - 1);
            i++;
        }

    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
//        System.out.println(combine(1, 1));
    }
}
