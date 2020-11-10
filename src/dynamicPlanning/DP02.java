package dynamicPlanning;

public class DP02 {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int i = coinChange(coins, 11);
        System.out.println(i);
    }

    public static int coinChange(int[] coins, int amount) {
        // 数组大小为 amount + 1，初始值也为 amount + 1
        int[] dp = new int[amount + 1];
        for(int i = 0;i < dp.length;i++){
            dp[i] = amount + 1;
        }
        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) continue;
                // 1 是1次的意思，减去的当前硬币币值说明减去了1次，前面的再加上1次就等于了当前的需要总值的次数
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

}
