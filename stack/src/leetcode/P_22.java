package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P_22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        StringBuilder currStr = new StringBuilder();
        backtrack(res, currStr, n, 0, 0);

        return res;
    }

    public void backtrack(List<String> res, StringBuilder currStr, int n, int open, int close) {
        if (open == n && close == n) {
            res.add(currStr.toString());
        }

        if (open < n) {
            backtrack(res, currStr.append('('), n, open + 1, close);
            currStr.deleteCharAt(currStr.length() - 1);
        }

        if (close < open) {
            backtrack(res, currStr.append(')'), n, open, close + 1);
            currStr.deleteCharAt(currStr.length() - 1);
        }
    }
}
