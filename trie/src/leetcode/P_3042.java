package leetcode;

/**
 * 3042. Count Prefix and Suffix Pairs I
 */
public class P_3042 {

    public int countPrefixSuffixPairs(String[] words) {

        int res = 0;

        for(int i = 0; i < words.length - 1; i++){
            for(int j = i + 1; j < words.length; j++){
                if(words[j].startsWith(words[i]) && words[j].endsWith(words[i])){
                    res++;
                }
            }
        }

        return res;
    }
}
