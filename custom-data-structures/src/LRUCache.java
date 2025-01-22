import java.util.HashMap;


class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class KeyValuePairLL extends LinkedList<Pair> {}

class LRUCache {
    int cacheCapacity;

    HashMap<Integer, LinkedListNode<Pair>> cacheMap = new HashMap<Integer, LinkedListNode<Pair>>();

    KeyValuePairLL cacheList = new KeyValuePairLL();

    // Constructor that sets the size of the cache
    public LRUCache(int size) {
        this.cacheCapacity = size;
    }

    int get(int key) {
        LinkedListNode<Pair> foundIter;

        if (cacheMap.containsKey(key))
            foundIter = cacheMap.get(key);
        else
            return -1;

        LinkedListNode<Pair> listIterator = foundIter;

        cacheList.remove(foundIter);
        cacheList.addFirst(listIterator);

        return listIterator.data.second;
    }

    void set(int key, int value) {
        if (cacheMap.containsKey(key)) {
            LinkedListNode<Pair> foundIter = cacheMap.get(key);

            cacheList.remove(foundIter);
            cacheList.addFirst(foundIter);

            foundIter.data.second = value;
            return;
        }

        if (cacheMap.size() == cacheCapacity) {
            int keyTmp = cacheList.getLast().data.first;
            cacheList.removeLast();
            cacheMap.remove(keyTmp);
        }

        cacheList.insertAtHead(new Pair(key, value));

        if (cacheMap.containsKey(key)) {
            cacheMap.replace(key, cacheList.getFirst());
        } else {
            cacheMap.put(key, cacheList.getFirst());
        }
    }

    // Prints the current state of the cache
    void print() {
        System.out.print("Cache current size: " + cacheList.size() + ", ");
        System.out.print("Cache contents: {");
        LinkedListNode<Pair> iter = cacheList.getFirst();
        while (iter != null) {
            Pair pair = iter.data;
            System.out.print("{" + pair.first + ": " + pair.second + "}");
            iter = iter.next;
            if (iter != null) {
                System.out.print(", ");
            }
        }

        System.out.print("}\n");
        System.out.println(new String(new char[100]).replace('\0', '-'));
    }
}
