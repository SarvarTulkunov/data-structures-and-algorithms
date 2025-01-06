import java.util.Comparator;
import java.util.PriorityQueue;

public class MinHeap<T> {
    private PriorityQueue<T> queue;

    public MinHeap(Comparator<T> comparator){
        queue = new PriorityQueue<>(comparator);
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
