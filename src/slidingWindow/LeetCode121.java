package slidingWindow;

/**
 * leetcode121: 买卖股票的最佳时机
 */
public class LeetCode121 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4}; // 8,2,1,3,4,5
        int max = maxProfit(prices);
        System.out.println(max);
    }

    // ans from leetcode
    private static int maxProfit(int[] prices) {
        int maxprofit = 0,min = Integer.MAX_VALUE;
        for(int i = 0;i < prices.length;i++){
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] - min > maxprofit){
                maxprofit = prices[i] - min;
            }
        }
        return maxprofit;
    }

}
