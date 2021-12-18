package leetcodeBasic.array;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int len = nums.length, re = 0;
        if (len == 1) return nums[0];
        for (int num : nums) {
            re ^= num;
        }
        return re;
    }
}
