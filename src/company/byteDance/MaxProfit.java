package company.byteDance;

public class MaxProfit {

    public int bruteForce(int[] prices) {
        int len = prices.length, max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int diff = prices[j] - prices[i];
                if (diff > max) max = diff;
            }
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        int max = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > max) {
                max = price - minPrice;
            }
        }
        return max;
    }

}
