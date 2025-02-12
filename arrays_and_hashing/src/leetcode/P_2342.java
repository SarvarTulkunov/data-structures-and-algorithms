package leetcode;

import java.util.*;

/**
 * 2342. Max Sum of a Pair With Equal Sum of Digits
 */
public class P_2342 {

    public static int maximumSum(int[] nums) {
        int maxSum = -1;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int n : nums) {
            int digitSum = sumOfDigits(n);
            map.putIfAbsent(digitSum, new ArrayList<>());

            List<Integer> currList = map.get(digitSum);
            currList.add(n);
            currList.sort(Collections.reverseOrder()); // Keep list sorted in descending order

            // Keep only the two largest numbers
            if (currList.size() > 2) {
                currList.remove(2);
            }

            // Calculate max sum if at least two numbers exist
            if (currList.size() == 2) {
                maxSum = Math.max(maxSum, currList.get(0) + currList.get(1));
            }

        }

        return maxSum;
    }

    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{18, 43, 36, 13, 7}));
        System.out.println(maximumSum(new int[]{10, 12, 19, 14}));
    }
}
