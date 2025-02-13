package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_3066 {

    public static int minOperations(int[] nums, int k) {
        int numberOfOperations = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int n : nums) pq.add((long) n);

        boolean flag = true;

        while (flag) {
            if (pq.size() >= 2 && pq.peek() < k) {
                long x = pq.poll();
                long y = pq.poll();
                pq.add(Math.min(x, y) * 2 + Math.max(x, y));
                numberOfOperations++;
                continue;
            }
            flag = false;
        }

        return numberOfOperations;
    }

    public static void main(String[] args) {
//        System.out.println(minOperations(new int[]{2, 11, 10, 1, 3}, 10));
//        System.out.println(minOperations(new int[]{1, 1, 2, 4, 9}, 20));
        System.out.println(minOperations(new int[]{1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999}, 1000000000));
    }
}
