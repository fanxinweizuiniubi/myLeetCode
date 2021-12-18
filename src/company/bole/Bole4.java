package company.bole;

public class Bole4 {

    public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,5};
        int sum = maximumSum(arr);
        System.out.println(sum);
    }

    public static int maximumSum(int[] arr) {
        // write code here
        int len = arr.length;
        int dp0 = -10^4, dp1 = -10^4, ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            // 加上新的和没加之前作比较取较大的那一个
            dp1 = Math.max(dp1 + arr[i], dp0);
            // 判断加上数组中的新的值和不加哪个比较大，用作判断是否有负数
            dp0 = Math.max(dp0 + arr[i], arr[i]);
            // 取两个记录之中较大的那一个，并和已经存在的最大值作比较
            ans = Math.max(ans, Math.max(dp0, dp1));
        }
        return ans;
    }

}
