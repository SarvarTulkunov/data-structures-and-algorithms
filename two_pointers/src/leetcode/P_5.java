package leetcode;

public class P_5 {

    public static String longestPalindrome(String s) {

        int resLen = 0;
        String res = "";

        for (int i = 0; i < s.length(); i++) {

            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

                if (right - left + 1 > resLen) {
                    resLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }

                left--;
                right++;
            }

            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

                if (right - left + 1 > resLen) {
                    resLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }

                left--;
                right++;
            }

        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("babad"));
//        System.out.println(longestPalindrome("abbc"));
        System.out.println(longestPalindrome("aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzzzzaabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyy"));
    }
}
