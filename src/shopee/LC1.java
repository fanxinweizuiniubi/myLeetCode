package shopee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1 {

    public static void main(String[] args) {
        int[] num = {3,3};
        int[] ints = twoSum2(num, 6);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0;i < nums.length;i++) {
            for (int j = i + 1;j < nums.length;j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
