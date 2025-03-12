package leetcode;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 */
public class P_215 {
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) pq.poll();
        }

        return !pq.isEmpty() ? pq.peek() : -1;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
