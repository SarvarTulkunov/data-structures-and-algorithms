package leetcode;

/**
 * 1641. Count Vowel Strings
 */
public class P_1641 {
    public static int countVowelStrings(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }
}
