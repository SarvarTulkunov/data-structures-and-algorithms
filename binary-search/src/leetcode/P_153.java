package leetcode;

public class P_153 {

    public static int findMin(int[] nums) {

        int left = 0, right = nums.length - 1;
        int mid;

        while (left < right) {
            mid = (right - left) / 2 + left;

            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 6, 1, 2}));
        System.out.println(findMin(new int[]{1, 2, 3, 4, 5, 6}));
//        System.out.println(findMin(new int[]{3, 4, 5, 6, 1, 2}));
    }
}
