package leetcode;

/**
 * 680. Valid Palindrome II
 */
public class P_680 {

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;j--;
            }
            else return isPalindrom(s, i + 1, j) || isPalindrom(s, i, j - 1);
        }

        return true;
    }

    public boolean isPalindrom(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;j--;
            }
            else return false;
        }
        return true;
    }

}
