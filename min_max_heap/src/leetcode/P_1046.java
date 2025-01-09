package leetcode;

import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight
 */
public class P_1046 {

    /**
     * Approach: max-heap
     */
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int max1 = maxHeap.poll();
            int max2 = maxHeap.poll();

            if (max1 != max2) {
                maxHeap.add(max1 - max2);
            }

        }

        return !maxHeap.isEmpty() ? maxHeap.poll() : 0;
    }

}
