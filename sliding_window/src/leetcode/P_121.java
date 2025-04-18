package leetcode;

public class P_121 {

    /**
     * Approach: sliding window
     */
    public static int maxProfit(int[] prices) {

        int l = 0, r = 1;
        int maxProfit = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                l = r;
            }
            r++;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(maxProfit(new int[]{10, 1, 5, 6, 7, 1}));
//        System.out.println(maxProfit(new int[]{10, 8, 7, 5, 2}));
    }
}
