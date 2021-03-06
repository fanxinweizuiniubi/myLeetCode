package dynamicPlanning;

public class DP01 {

    public static void main(String[] args) {
        int fib = fib(3);
        System.out.println(fib);
    }

    public static int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
