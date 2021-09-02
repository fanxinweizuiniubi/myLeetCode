package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubArraySum {

    //Function to find a continuous sub-array which adds up to a given number.
    static List<Integer> subarraySum(int[] arr, int n, int s)
    {
        if (arr == null) return new ArrayList<>(Collections.singletonList(-1));
        // Your code here
        // 思想：一个一个加入滑动窗口，如果总和大于给定数字，把最左元素删除
        int start = 0, i , curSum = arr[0];
        // init window
        for (i = 1; i < n; i++) {
            // 总和大于给定数字

            // 总和等于给定数字
            // 总和小于给定数字
        }
        return new ArrayList<>(Collections.singletonList(-1));
    }

}
