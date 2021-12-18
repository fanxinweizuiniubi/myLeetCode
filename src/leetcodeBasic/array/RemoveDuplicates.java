package leetcodeBasic.array;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int p = 0, len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[p] != nums[i]) {
                p++;
                nums[p] = nums[i];
            }
        }
        return p + 1;
    }
}
