package leetcode;

import java.util.*;

/**
 * 3211. Generate Binary Strings Without Adjacent Zeros
 * <p>
 * You are given a positive integer n.
 * <p>
 * A binary string x is valid if all
 * substrings
 * of x of length 2 contain at least one "1".
 * <p>
 * Return all valid strings with length n, in any order.
 */
public class P_3211 {

    public static List<String> validStrings(int n) {

        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder("0".repeat(n));

        dfs(res, 0, str, -1);

        return new ArrayList<>(res);
    }

    public static void dfs(List<String> res, Integer index, StringBuilder str, Integer lastChar) {

        if (index == str.length()) {
            res.add(str.toString());
            return;
        }

        // Add '1' to the string
        str.setCharAt(index, '1');
        dfs(res, index + 1, str, 1);
        str.setCharAt(index, '0');

        // Add '0' to the string, only if the last character was not '0'
        if (lastChar != 0) {
            str.setCharAt(index, '0');
            dfs(res, index + 1, str, 0);
            str.setCharAt(index, '0');
        }
    }


    public static void main(String[] args) {
        System.out.println(validStrings(3).toString());
    }
}
