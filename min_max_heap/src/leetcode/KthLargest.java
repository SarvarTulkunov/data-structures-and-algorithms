package leetcode;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 */
public class KthLargest {

    private int k;
    private final PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) pq.poll();
        return !pq.isEmpty() ? pq.peek() : -1;
    }
}
