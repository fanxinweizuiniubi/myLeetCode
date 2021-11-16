package knapsack;

public class TargetSum {

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,1};
        TargetSum targetSum = new TargetSum();
        int res = targetSum.findTargetSumWays(nums, 1);
        System.out.println(res);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum < target || (target + sum) % 2 > 0 ? 0 : subsetSum(nums, (sum - target) >>> 1);
    }

    private int subsetSum(int[] nums, int target) {
        int len = nums.length;
        int[][] dp = new int[len + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[len][target];
    }

}
