package leetcode;


import java.util.Arrays;

/**
 * 242. Valid Anagram
 */
public class P_242 {

    // anagram
    // nagaram
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int n : counter) {
            if (n != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        isAnagram("anagramb", "nagaramd");
        System.out.println(isAnagram("racecar", "carrace"));
    }
}
