package leetcode;


/**
 * 997. Find the Town Judge
 */
public class P_997 {

    public int findJudge(int n, int[][] trust) {

        if (n == 1) return 1;  // If there's only one person, they are the judge by default.

        int[] trustCount = new int[n + 1];  // trustCount[i] counts how many people trust person i
        int[] trustedBy = new int[n + 1];   // trustedBy[i] counts how many people person i trusts

        // Process the trust relationships
        for (int[] pair : trust) {
            trustedBy[pair[0]]++;  // person pair[0] trusts someone
            trustCount[pair[1]]++; // person pair[1] is trusted by someone
        }

        // Find the judge
        for (int i = 1; i <= n; i++) {
            // A judge must be trusted by exactly n-1 people and trust no one
            if (trustCount[i] == n - 1 && trustedBy[i] == 0) {
                return i;
            }
        }

        return -1;  // No judge found
    }

    public static void main(String[] args) {

    }
}
