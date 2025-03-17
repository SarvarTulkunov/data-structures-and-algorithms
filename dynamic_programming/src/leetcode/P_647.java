package leetcode;

public class P_647 {

    public int countSubstrings(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd length
            int l = i, r = i;
            while (l >= 0 && r < s.length() &&
                    s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }

            // even length
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() &&
                    s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }
        }

        return res;
    }
    // Time Complexity O(n^2)
    // Space Complexity O(1)

/*

    public int countSubstrings(String s) {
        int res = 0, n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (j - i <= 2 || dp[i + 1][j - 1])) {

                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }
    // Time Complexity O(n^2)
    // Space Complexity O(n^2)
*/

}
