package leetcodeBasic.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean b = containsDuplicate.containsDuplicate1(new int[]{1, 2, 3, 4});
        System.out.println(b);
    }

    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate0(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                return true;
            }
            map.put(i, 1);
        }
        return false;
    }
}
