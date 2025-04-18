package leetcode;


// 88. Merge Sorted Array
public class P_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, k = n + m - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

    }

}
