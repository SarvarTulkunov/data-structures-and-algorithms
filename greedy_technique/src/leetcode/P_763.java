package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 763. Partition Labels
 */
public class P_763 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();

        int n = s.length();
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            lastIndexMap.put(s.charAt(i), i);
        }

        int endIndex = lastIndexMap.get(s.charAt(0));
        int partitionSize = 0;
        for (int i = 0; i < n; i++) {
            partitionSize++;
            endIndex = Math.max(endIndex, lastIndexMap.get(s.charAt(i)));

            if (i == endIndex) {
                res.add(partitionSize);
                partitionSize = 0;
            }
        }

        return res;
    }

}
