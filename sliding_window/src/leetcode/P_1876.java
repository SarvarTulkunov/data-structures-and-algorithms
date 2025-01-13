package leetcode;

/**
 * 1876. Substrings of Size Three with Distinct Characters
 */
public class P_1876 {

    /**
     * Approach: Sliding window
     */
    public static int countGoodSubstrings(String s) {

        if (s.length() < 3) return 0;

        int counter = 0;

        for (int i = 0; i < s.length() - 2; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            char c3 = s.charAt(i + 2);

            if(c1 == c2 || c2 == c3 || c3 == c1){
                continue;
            }

            counter++;
        }

        return counter;
    }

    public static void main(String[] args) {
//        System.out.println(countGoodSubstrings("xyzzaz"));
//        System.out.println(countGoodSubstrings("aababcabc"));
        System.out.println(countGoodSubstrings("abcabcbb"));
    }
}
