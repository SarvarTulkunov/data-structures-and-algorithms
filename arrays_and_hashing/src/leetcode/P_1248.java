package leetcode;


/**
 * 1248. Count Number of Nice Subarrays
 * Description: Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
 * Return the number of nice sub-arrays.
 */
public class P_1248 {

    /**
     * Approach: Sliding window
     */
    /*
    public static int numberOfSubArrays(int[] nums, int k) {

        int l = 0;

        int counter = 0, res = 0, n = nums.length;
        for (int r = 0; r < n; r++) {

            if (nums[r] % 2 == 1) {
                counter++;
            }

            while (counter > k && l < n) {
                if (nums[l] % 2 == 1) {
                    counter--;
                }
                l++;
            }

            if (counter == k) {
                int j = l + 1;
                int tempCounter = k;
                if (nums[l] % 2 == 1) tempCounter--;
                while (tempCounter == k && j <= r) {

                    if (nums[j] % 2 == 1) {
                        tempCounter--;
                        res++;
                    }

                    if (tempCounter == k) {
                        res++;
                    }

                    j++;
                }
                res++;
            }

        }

        return res;
    }
    */


    /**
     * Approach: Sliding window
     * Optimize solution
     */
    public static int numberOfSubArrays(int[] A, int k) {
        int res = 0, i = 0, count = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            if (A[j] % 2 == 1) {
                --k;
                count = 0;
            }
            while (k == 0) {
                k += A[i++] & 1;
                ++count;
            }
            res += count;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubArrays(new int[]{1, 1, 2, 1, 1}, 3)); // Answer: 2
        System.out.println(numberOfSubArrays(new int[]{2, 4, 6}, 1)); // Answer: 0
        System.out.println(numberOfSubArrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2)); // Answer: 16
        System.out.println(numberOfSubArrays(new int[]{2044, 96397, 50143}, 1)); // Answer: 3
    }
}
