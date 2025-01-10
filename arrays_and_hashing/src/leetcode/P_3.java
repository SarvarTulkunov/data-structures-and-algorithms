package leetcode;

import java.util.HashMap;
import java.util.Map;

public class P_3 {

    public static int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        Map<Character, Integer> map = new HashMap<>();

        int maxLen = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (map.containsKey(s.charAt(i))) {
                map.remove(s.charAt(j));
                j++;
            }
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - j + 1);
        }

        return maxLen;
    }

}
