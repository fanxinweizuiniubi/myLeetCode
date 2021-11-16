package knapsack.unbounded;

public class UnboundedKnapsack {

    // Returns the maximum value with knapsack
    // of W capacity
    private static int unboundedKnapsack(int target, int n,
                                         int[] val, int[] wt)
    {

        // dp[i] is going to store maximum value
        // with knapsack capacity i.
        int[] dp = new int[target + 1];

        // Fill dp[] using above recursive formula
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (wt[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        return dp[target];
    }

    // Driver program
    public static void main(String[] args)
    {
        int target = 100;
        int[] val = {1, 30};
        int[] wt = {1, 50};
        int n = val.length;
        System.out.println(unboundedKnapsack(target, n, val, wt));
    }

}
