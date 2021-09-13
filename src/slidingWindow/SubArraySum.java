package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SubarraySum {

    static List<Integer> subarraySum(int[] arr, int n, int s) {
        if (arr == null) return new ArrayList<>(Collections.singletonList(-1));
        int start = 0, i, curSum = arr[0];
        for (i = 1; i <= n; i++) {
            while (curSum > s && start < i - 1) {
                curSum -= arr[start];
                start++;
            }
            if (curSum == s) return new ArrayList<>(Arrays.asList(start + 1, i - 1 + 1));
            if (i < n) curSum += arr[i];
        }
        return new ArrayList<>(Collections.singletonList(-1));
    }

}
