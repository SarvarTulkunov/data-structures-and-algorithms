package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin
 */
public class P_973 {

    /**
     * Approach: Max heap
     */
    public static int[][] kClosest(int[][] points, int k) {

        int[][] res = new int[k][2];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> calculateDistance(b[0], b[1]) - calculateDistance(a[0], a[1]));

        for (int[] point : points) {
            if (maxHeap.size() >= k) {
                if (calculateDistance(maxHeap.peek()[0], maxHeap.peek()[1]) > calculateDistance(point[0], point[1])) {
                    maxHeap.poll();
                    maxHeap.add(point);
                }
            } else {
                maxHeap.add(point);
            }
        }

        int i = 0;
        while (!maxHeap.isEmpty()) {
            res[i] = maxHeap.poll();
            System.out.println(Arrays.toString(res[i]));
            i++;
        }

        return res;
    }

    public static int calculateDistance(int x, int y) {
        return Math.abs(x * x + y * y);
    }


    public static void main(String[] args) {
        int[][] arr = new int[3][2];

        arr[0] = new int[]{0, 2};
        arr[1] = new int[]{2, 0};
        arr[2] = new int[]{2, 2};

        System.out.println(kClosest(arr, 2));
    }
}
