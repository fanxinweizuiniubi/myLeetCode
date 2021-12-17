package company.huawei;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int tar = 18;
        int[] ans = twoSum(nums, tar);
        System.out.println(ans);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }

}
