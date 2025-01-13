package leetcode;

/**
 * 1758. Minimum Changes To Make Alternating Binary String
 */
public class P_1758 {

    public int minOperations(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                if (c == '0') count++;
            } else {
                if (c == '1') count++;
            }
        }

        return Math.min(count, s.length() - count);
    }

}
