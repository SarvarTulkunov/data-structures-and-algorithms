package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. Majority Element II
 */
public class P_229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int count1 = 0, count2 = 0;

        // take the integers as the maximum
        // value of integer hoping the integer
        // would not be present in the array
        int first = Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;

        int n = nums.length;

        for (int num : nums) {

            // if this element is previously
            // seen, increment count1.
            if (first == num)
                count1++;

                // if this element is previously
                // seen, increment count2.
            else if (second == num)
                count2++;

            else if (count1 == 0) {
                count1++;
                first = num;
            } else if (count2 == 0) {
                count2++;
                second = num;
            }

            // if current element is different
            // from both the previously seen
            // variables, decrement both the
            // counts.
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        // Again traverse the array and
        // find the actual counts.
        for (int num : nums) {
            if (num == first) count1++;
            else if (num == second) count2++;
        }

        if (count1 > n / 3) res.add(first);

        if (count2 > n / 3) res.add(second);

        return res;
    }

}
