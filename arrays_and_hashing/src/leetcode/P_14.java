package leetcode;

/**
 * 14. Longest Common Prefix
 */
public class P_14 {

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            int j = prefix.length();
            while (!strs[i].startsWith(prefix)) {
                j--;
                prefix = prefix.substring(0, j);
            }

        }

        return prefix;
    }

}
