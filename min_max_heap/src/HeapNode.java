public class HeapNode implements Comparable<HeapNode> {
    int arrNumber;
    int index;
    int value;

    HeapNode(int arrNumber, int index, int value) {
        this.arrNumber = arrNumber;
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(HeapNode h) {
        if (this.value <= h.value) {
            return -1;
        } else {
            return 1;
        }
    }
}
