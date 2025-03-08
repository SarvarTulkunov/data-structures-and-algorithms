package leetcode;

/**
 * 706. Design HashMap
 */
public class MyHashMap {

    private final int[] map;

    public MyHashMap() {
        map = new int[1_000_000];
    }

    public void put(int key, int value) {
        if (value == 0) {
            map[key] = -1;
        } else {
            map[key] = value;
        }
    }

    public int get(int key) {
        int val = map[key];

        if (val != 0) {
            if (val == -1) return 0;
            return map[key];
        }

        return -1;
    }

    public void remove(int key) {
        map[key] = 0;
    }

}
