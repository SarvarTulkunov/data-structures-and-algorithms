package leetcode;

// 26. Remove Duplicates from Sorted Array
public class P_26 {

    public static int removeDuplicates(int[] nums) {

        int i = 0;
        if(nums.length == 1) return 1;

        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

}
