package leetcode;

import java.util.*;

/**
 * Letter Combinations of a Phone Number
 */
public class P_17 {

    Map<Character, List<String>> numberMap = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        numberMap.put('2', Arrays.asList(new String[]{"a", "b", "c"}));
        numberMap.put('3', Arrays.asList(new String[]{"d", "e", "f"}));
        numberMap.put('4', Arrays.asList(new String[]{"g", "h", "i"}));
        numberMap.put('5', Arrays.asList(new String[]{"j", "k", "l"}));
        numberMap.put('6', Arrays.asList(new String[]{"m", "n", "o"}));
        numberMap.put('7', Arrays.asList(new String[]{"p", "q", "r", "s"}));
        numberMap.put('8', Arrays.asList(new String[]{"t", "u", "v"}));
        numberMap.put('9', Arrays.asList(new String[]{"w", "x", "y", "z"}));

        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>();
        StringBuilder subString = new StringBuilder();

        dfs(digits, subString, 0, res);

        return res;
    }

    private void dfs(String digits, StringBuilder subString, int index, List<String> res) {
        if (index >= digits.length()) {
            res.add(subString.toString());
            return;
        }

        for (String letter : numberMap.get(digits.charAt(index))) {
            subString.append(letter);
            dfs(digits, subString, index + 1, res);
            subString.deleteCharAt(subString.length() - 1);
        }
    }

}
