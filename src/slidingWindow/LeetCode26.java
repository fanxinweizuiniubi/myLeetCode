package slidingWindow;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 */
public class LeetCode26 {

    public static void main(String[] args) {
        int[] nums = {1,1};
        int len = removeDuplicates1(nums);
        System.err.println(len);
    }

    // my solution
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0,j = 0,k = 1;
        while(j != nums.length - 1){
            j = i + 1;
            while(nums[j] == nums[i]){
                if(j == nums.length - 1) return k;
                j++;
            }
            nums[k] = nums[j];
            i = j;
            k++;
        }
        return k;
    }

    public static int removeDuplicates1(int[] nums){
        int i = 0;
        for(int j = 1;j < nums.length;j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
