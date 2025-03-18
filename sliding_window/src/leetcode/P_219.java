package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 219. Contains Duplicate II
 */
public class P_219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 1) return false;

        Set<Integer> set = new HashSet<>();

        // avoid index out of bound exception
        k = Math.min(k, nums.length - 1);

        for (int i = 0; i <= k; i++) {
            if (!set.add(nums[i])) return true;
        }

        for (int i = k + 1; i < nums.length; i++) {
            set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
//        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    }
}
