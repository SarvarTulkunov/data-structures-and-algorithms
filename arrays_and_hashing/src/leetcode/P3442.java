package leetcode;

public class P3442 {

    public int maxDifference(String s) {
        int a1 = Integer.MIN_VALUE, a2 = Integer.MAX_VALUE;

        int[] charFreq = new int[26];

        for (char c : s.toCharArray()) {
            charFreq[c - 'a']++;
        }

        for (int n : charFreq) {
            if (n != 0 && n % 2 == 0) {
                a2 = Math.min(a2, n);
            } else {
                a1 = Math.max(a1, n);
            }
        }

        return a1 - a2;
    }
}
