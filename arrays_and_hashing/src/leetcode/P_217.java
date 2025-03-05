package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 */
public class P_217 {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

}
