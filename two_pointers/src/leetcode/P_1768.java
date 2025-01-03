package leetcode;

 // 1768. Merge Strings Alternately
public class P_1768 {

    public static String mergeAlternately(String word1, String word2) {
        int i = 0, j1 = word1.length(), j2 = word2.length();

        StringBuilder res = new StringBuilder();

        while (i < Math.min(j1, j2)) {
            res.append(word1.charAt(i)).append(word2.charAt(i++));
        }
        while (i < j1) {
            res.append(word1.charAt(i++));
        }
        while (i < j2) {
            res.append(word2.charAt(i++));
        }

        return res.toString();
    }

}
