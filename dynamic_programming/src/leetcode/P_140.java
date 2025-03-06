package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 140. Word Break II
 */
public class P_140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> dp = new ArrayList<>(s.length() + 1);
        for (int i = 0; i <= s.length(); i++) {
            dp.add(new ArrayList<>());
        }

        dp.get(0).add("");

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            List<String> temp = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                String suffix = prefix.substring(j);

                if (wordDict.contains(suffix)) {

                    for (String substring : dp.get(j)) {
                        temp.add(substring + (substring.isEmpty() ? "" : " ") + suffix);
                    }
                }
            }

            dp.set(i, temp);
        }

        return dp.get(s.length());
    }
}
