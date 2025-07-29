package leetcode;

public class P2486 {

    public static int appendCharacters(String s, String t) {

        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return t.length() - j;
    }

    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching", "coding"));
        System.out.println(appendCharacters("abcde", "a"));
        System.out.println(appendCharacters("vrykt", "rkge")); // 2
    }
}
