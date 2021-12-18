package leetcodeBasic.array;

public class MaxProfit {

    /** 可以优化成不用二维数组，只用两个额外参数，二维数组的更容易理解，就不写另一种了 */
    public int maxProfitDp(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    /** 贪心 */
    public int maxProfit(int[] prices) {
        int max = 0, len = prices.length;
        if (len <= 1) return 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }
}
