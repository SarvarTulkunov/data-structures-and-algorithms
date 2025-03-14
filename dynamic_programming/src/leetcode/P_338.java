package leetcode;

/**
 * 338. Counting Bits
 */
public class P_338 {
    public static int[] countingBits(int n) {

        int[] result = new int[n + 1];

        if (n == 0) {
            return result;
        }

        result[0] = 0;
        result[1] = 1;

        for (int x = 2; x <= n; ++x) {
            if ((x % 2) == 0) {
                result[x] = result[x / 2];
            }
            else {
                result[x] = result[x / 2] + 1;
            }
        }

        return result;
    }
}
