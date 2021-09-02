package slidingWindow;

import java.util.Arrays;
import java.util.List;

public class MaximumSumSubarray {

    public static void main(String[] args) {
        maximumSumSubarray(2, Arrays.asList(100, 200, 300, 400), 4);
    }

    static int maximumSumSubarray(int K, List<Integer> Arr, int N){
        // code here
        if (K > N) return -1;
        int max = 0;
        // init window
        for (int i = 0;i < K;i++)  max += Arr.get(i);
        int curMax = max;
        for (int i = K;i < N;i++) {
            curMax += Arr.get(i) - Arr.get(i - K);
            max = Math.max(curMax, max);
        }
        return max;
    }

}
