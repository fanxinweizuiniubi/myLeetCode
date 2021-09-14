package mergeIntervals;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{1,4}, {0,2}, {3,5}};
        mergeIntervals.merge(intervals);
    }

    public int[][] mergeOfficial(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
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
