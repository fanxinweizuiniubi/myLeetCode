package mergeSection;

import java.util.Arrays;

/**
 * 合并区间
 */
public class LeetCode56 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 6}};
        intervals = merge(intervals);
        System.out.println("err");
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> (v1[0] - v2[0]));
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(interval[1], res[idx][1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

}
