import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKArrays {

    public static List<Integer> mergeKArrays(int[][] arr, int K) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<HeapNode> heap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            heap.add(new HeapNode(i, 0, arr[i][0]));
        }

        HeapNode curr;
        while (!heap.isEmpty()) {
            curr = heap.poll();
            result.add(curr.value);

            if (curr.index < (arr[curr.arrNumber].length - 1)) {
                heap.add(new HeapNode(
                        curr.index,
                        curr.arrNumber + 1,
                                arr[curr.index][curr.arrNumber + 1]));
            }
        }

        return result;
    }
}
