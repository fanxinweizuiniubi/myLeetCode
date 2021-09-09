package twoPointers;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        threeSumClosest.threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 0, min = Integer.MAX_VALUE, len = nums.length, diff;
        for (int i = 0; i < len - 2; i++) {
            int l = i + 1, r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) return 0;
                else if (sum < 0) l++;
                else r--;
                diff = Math.abs(target - sum);
                if (diff < min) {
                    min = diff;
                    closest = sum;
                }
            }
        }
        return closest;
    }

}
