package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return null;
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int L,R;
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            L = i + 1;
            R = len - 1;
            while(L < R){
                if(nums[i] + nums[L] + nums[R] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    result.add(list);
                    while(L < R && nums[L] == nums[L+1])
                        L += 1;
                    while(L < R && nums[R] == nums[R-1])
                        R -= 1;
                    L += 1;
                    R -= 1;
                }else if(nums[i] + nums[L] + nums[R] > 0)
                    R -= 1;
                else
                    L += 1;
            }
        }
        return result;
    }

}
