package slidingWindow;

import java.util.Arrays;

public class LeetCode16 {

    public static void main(String[] args) {
        int[] nums = {1,2,4,8,16,32,64,128};
        int target = 82;
        int sum = threeSumClosest(nums,target);
        System.out.println(sum);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int start,end,ans = nums[0] + nums[1] + nums[2],sum = 0;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            start = i + 1;
            end = nums.length - 1;
            while(start < end){
                sum = nums[i] + nums[start] + nums[end];
                if(Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum;
                }
                if(sum > target){
                    end--;
                }else if(sum < target){
                    start++;
                }else{
                    return ans;
                }
            }
        }
        return ans;
    }

}
