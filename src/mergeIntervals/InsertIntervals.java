package mergeIntervals;

import java.util.*;

public class InsertIntervals {

    public int[][] insertOfficial(int[][] intervals, int[] newInterval) {
        int len = intervals.length, p = 0;
        List<int[]> res = new ArrayList<>();
        while (p < len && intervals[p][1] < newInterval[0]) {
            res.add(intervals[p]);
            p++;
        }
        while (p < len && intervals[p][0] <= newInterval[1]) {
            newInterval = new int[]{Math.min(newInterval[0], intervals[p][0]),
                                    Math.max(newInterval[1], intervals[p][1])};
            p++;
        }
        res.add(newInterval);
        while (p < len) {
            res.add(intervals[p]);
            p++;
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> re = new LinkedList<>(Arrays.asList(intervals));
        re.add(newInterval);
        return mergeOfficial(re.toArray(new int[re.size()][]));
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

}
