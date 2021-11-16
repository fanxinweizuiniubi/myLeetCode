package knapsack.knapsack01;

public class Knapsack {

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        int max1 = knapsack.solveKnapsack(new int[]{1500, 3000, 2000, 2000}, new int[]{1, 4, 3, 1}, 4, 4);
        System.out.println(max1);
        int max2 = knapsack.solveKnapsack(new int[]{1500, 3000, 2000}, new int[]{1, 4, 3}, 4, 3);
        System.out.println(max2);
    }

    public int solveKnapsack(int[] values, int[] weights, int capacity, int num) {
        int[][] maxValue = new int[num][capacity + 1];
        for (int i = 0; i < num; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (i == 0) {
                    maxValue[i][j] = weights[i] <= j ? values[i] : 0;
                } else {
                    int lastMax = maxValue[i - 1][j];
                    int cur = weights[i] > j ? lastMax : values[i] + maxValue[i - 1][j - weights[i]];
                    maxValue[i][j] = Math.max(lastMax, cur);
                }
            }
        }
        return maxValue[num -1][capacity];
    }

}
