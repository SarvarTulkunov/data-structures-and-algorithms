package leetcode;

public class P_1800 {

    public int maxAscendingSum(int[] nums) {
        int sum = 0;
        int prev = 0;
        int res = 0;

        for (int curr : nums) {
            if (curr > prev) {
                sum += curr;
            } else {
                res = Math.max(res, sum);
                sum = curr;
            }
            prev = curr;
        }

        res = Math.max(res, sum);

        return res;
    }
}
