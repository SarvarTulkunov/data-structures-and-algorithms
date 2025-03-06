package leetcode;

import java.util.*;

/**
 * 49. Group Anagrams
 */
public class P_49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                map.get(key).add(str);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            ans.add(new ArrayList<>(list));
        }

        return ans;
    }
}
