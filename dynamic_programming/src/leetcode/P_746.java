package leetcode;

/**
 * 746. Min Cost Climbing Stairs
 */
public class P_746 {

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) return Math.min(cost[0], cost[1]);

        int i = cost[0] + cost[2] < cost[1] ? 0 : 1;

        int res = cost[i];

        while (i < cost.length - 2) {

            if (cost[i + 2] < cost[i + 1]) {
                i += 2;
            } else {
                i++;
            }

            res += cost[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 2, 3}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
//        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

}
