package knapsack.knapsack01;

import java.util.Arrays;

public class SubsetSum {

    public static void main(String[] args) {
        SubsetSum subsetSum = new SubsetSum();
        boolean b = subsetSum.canPartition(new int[]{1,2,2,1});
        System.out.println(b);
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];
        if (nums[0] <= target) dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
            }
            if (dp[i][target]) return true;
        }
        return dp[len - 1][target];
    }

}
