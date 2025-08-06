package leetcode;

public class P_33 {

    public static int search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] == target) return m;

            if (nums[l] <= nums[m]) {
                if (target > nums[m] || target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (target < nums[m] || target > nums[r]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 4, 5, 6, 1, 2}, 1));
        System.out.println(search(new int[]{3, 5, 6, 0, 1, 2}, 4));
//        System.out.println(search(new int[]{0, 1, 2, 3, 4, 5}, 4));
        System.out.println(search(new int[]{5, 1, 3}, 5));
    }
}
