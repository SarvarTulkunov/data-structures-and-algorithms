package leetcode;

// 283. Move Zeroes
public class P_283 {

    public static void moveZeroes(int[] nums) {
        int i = 0;

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

    }

}
