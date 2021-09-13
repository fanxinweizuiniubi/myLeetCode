package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit {

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> baskets = new HashMap<>();
        int n = fruits.length, start = 0, max= 0, sum = 0;
        for (int i = 0; i < n; i++) {
            baskets.put(fruits[i], baskets.getOrDefault(fruits[i], 0) + 1);
            while (baskets.size() > 2) {
                baskets.put(fruits[start], baskets.get(fruits[start]) - 1);
                if (baskets.get(fruits[start]) == 0) {
                    baskets.remove(fruits[start]);
                }
                start++;
            }
            if (baskets.size() == 2) {
                sum = 0;
                for (Integer type : baskets.keySet()) {
                    sum += baskets.get(type);
                }
                if (sum > max) max = sum;
            }
            if (i == n - 1 && baskets.size() == 1) {
                max = baskets.get(fruits[0]);
            }
        }
        return max;
    }

}
