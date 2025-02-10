package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2364. Count Number of Bad Pairs
 * You are given a 0-indexed integer array nums.
 * A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].
 * Return the total number of bad pairs in nums.
 */
public class P_2364 {

    public static long countBadPairs(int[] nums) {

        Map<Integer, Integer> diffMap = new HashMap<>();
        long res = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            diffMap.put(i - nums[i], diffMap.getOrDefault(i - nums[i], 0) + 1);
        }

        for (Integer val : diffMap.values()) {
            res += (long) (n - val) * val;
        }

        return res / 2;
    }

    public static void main(String[] args) {
        System.out.println(countBadPairs(new int[]{4, 1, 3, 3}));
    }
}
