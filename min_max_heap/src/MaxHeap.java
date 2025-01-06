import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap<T> {
    private PriorityQueue<T> queue;

    public MaxHeap(Comparator<T> comparator){
        queue = new PriorityQueue<>(comparator.reversed());
    }

    public void add(T newElement){
        queue.add(newElement);
    }

    public T peek(){
        return queue.peek();
    }

    public T poll(){
        return queue.poll();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
