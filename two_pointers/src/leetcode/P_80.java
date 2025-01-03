package leetcode;

// 80. Remove Duplicates from Sorted Array II
public class P_80 {

    public int removeDuplicates(int[] nums) {
        int i = 2;

        for(int j = 2; j < nums.length; j++){
            if(nums[j] != nums[i - 2]) nums[i++] = nums[j];
        }

        return i;
    }

}
