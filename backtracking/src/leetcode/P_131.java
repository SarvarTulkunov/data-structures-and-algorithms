package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 */
public class P_131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> subset = new ArrayList<>();

        dfs(s, 0, subset, res);

        return res;
    }

    private void dfs(String s, int i, List<String> subset, List<List<String>> res) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(subset));
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                subset.add(s.substring(i, j + 1));
                dfs(s, j + 1, subset, res);
                subset.remove(subset.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
