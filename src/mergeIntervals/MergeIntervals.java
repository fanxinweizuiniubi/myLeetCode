package mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{1,4}, {0,2}, {3,5}};
        mergeIntervals.merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int len = intervals.length, p = 0;
        int[][] re = new int[len][];
        re[p] = intervals[p];
        for (int i = 1; i < len; i++) {
            // not overlap
            if (intervals[i][0] > re[p][1] || re[p][0] > intervals[i][1]) {
                p++;
                re[p] = intervals[i];
            } else {
                int max = Math.max(intervals[i][1], re[p][1]);
                int min = Math.min(intervals[i][0], re[p][0]);
                re[p] = new int[]{min, max};
            }
        }
        int reLen = 0;
        for (int i = 0; i < len; i++) {
            if (re[i] != null) reLen++;
        }
        int[][] ans = new int[reLen][];
        if (reLen >= 0) System.arraycopy(re, 0, ans, 0, reLen);
        return ans;
    }

}
