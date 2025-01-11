package leetcode;

import java.util.HashMap;
import java.util.Map;

public class P_424 {

    public int characterReplacement(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int maxF = 0;
        int res = 0, l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxF = Math.max(maxF, map.get(c));

            while ((r - l + 1) - maxF > k) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }

            res = Math.max(res, (r - l + 1));
        }

        return res;
    }

}
