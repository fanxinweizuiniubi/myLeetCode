package company.huawei;

import java.util.HashMap;
import java.util.Map;

public class LeetCode260 {

    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        int singleNumber = singleNumber(nums);
        System.out.println(singleNumber);
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer in : map.keySet()){
            if(map.get(in) == 1){
                ans = in;
            }
        }
        return ans;
    }

}
