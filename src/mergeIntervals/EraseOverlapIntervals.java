package mergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class EraseOverlapIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
        eraseOverlapIntervals.eraseOverlapIntervals(intervals);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int len = intervals.length;
        LinkedList<int[]> record = new LinkedList<>();
        for (int[] interval : intervals) {
            if (record.isEmpty() || record.getLast()[1] <= interval[0]) {
                record.add(interval);
            }
        }
        return len - record.size();
    }

}
