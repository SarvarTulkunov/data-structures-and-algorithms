package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P228 {

    public static List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();
        int prev = nums[0];
        int next = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == next + 1) {
                next = nums[i];
            } else {
                if (prev == next) {
                    result.add(prev + "");
                } else {
                    result.add(prev + "->" + next);
                }
                prev = nums[i];
                next = nums[i];
            }
        }

        if (prev == next) {
            result.add(String.valueOf(prev));
        } else {
            result.add(prev + "->" + next);
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }
}
