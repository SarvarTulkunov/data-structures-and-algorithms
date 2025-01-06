import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        MinHeap<Integer> minHeap = new MinHeap(Comparator.comparingInt(value -> (int) value));

        minHeap.add(7);
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(4);
        minHeap.add(1);
        minHeap.add(9);

        System.out.println(minHeap.peek());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());

        MinHeap<Integer> maxHeap = new MinHeap(Collections.reverseOrder());

        maxHeap.add(5);
        maxHeap.add(9);
        maxHeap.add(10);
        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(513);

        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());


        // ===========================================================================
        StudentComparator comparator = new StudentComparator();

        MinHeap<Student> studentMinHeap = new MinHeap(comparator);

        studentMinHeap.add(new Student("123", "Kamron", 4));
        studentMinHeap.add(new Student("140", "Akmal", 3));
        studentMinHeap.add(new Student("200", "Javohir", 2));
        studentMinHeap.add(new Student("431", "Javlon", 5));
        studentMinHeap.add(new Student("130", "Murod", 1));

        System.out.println(studentMinHeap.poll());
        System.out.println(studentMinHeap.poll());
        System.out.println(studentMinHeap.poll());
        System.out.println(studentMinHeap.poll());

        MaxHeap<Student> studentMaxHeap = new MaxHeap<>(comparator);

        studentMaxHeap.add(new Student("123", "Kamron", 4));
        studentMaxHeap.add(new Student("140", "Akmal", 3));
        studentMaxHeap.add(new Student("200", "Javohir", 2));
        studentMaxHeap.add(new Student("431", "Javlon", 5));
        studentMaxHeap.add(new Student("130", "Murod", 1));

        System.out.println(studentMaxHeap.poll());
        System.out.println(studentMaxHeap.poll());
        System.out.println(studentMaxHeap.poll());
    }
}