package bole;

public class Bole4 {

    public static void main(String[] args) {
        int[] arr = {2, -1, 0, 4};
        int sum = maximumSum(arr);
        System.out.println(sum);
    }

    public static int maximumSum(int[] arr) {
        // write code here
        int len = arr.length;
        int dp0 = -10^4, dp1 = -10^4, ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            dp1 = Math.max(dp1 + arr[i], dp0);
            dp0 = Math.max(dp0 + arr[i], arr[i]);
            ans = Math.max(ans, Math.max(dp0, dp1));
        }
        return ans;
    }

}
