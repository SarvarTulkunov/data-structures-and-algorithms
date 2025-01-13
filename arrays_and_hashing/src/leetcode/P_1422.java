package leetcode;

/**
 * 1422. Maximum Score After Splitting a String
 */
public class P_1422 {

    public static int maxScore(String s) {

        int res = 0;
        int numOfZeros = 0, numOfOnes = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') numOfOnes++;
        }

        for (int i = 0; i < s.length() - 1; i++) {

            if (s.charAt(i) == '1') {
                numOfOnes--;
            } else {
                numOfZeros++;
            }

            res = Math.max(res, numOfZeros + numOfOnes);

        }

        return res;
    }

}
