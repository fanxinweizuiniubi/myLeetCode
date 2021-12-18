package mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] intervals = {{1,3}, {6,9}};
        int[] newInterval = {2,5};
        insertInterval.insert(intervals, newInterval);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int p = 0, len = intervals.length;
        List<int[]> re = new ArrayList<>();
        while (p < len && intervals[p][1] < newInterval[0]) {
            re.add(intervals[p]);
            p++;
        }
        while (p < len && newInterval[1] >= intervals[p][0]) {
            newInterval = new int[]{Math.min(newInterval[0], intervals[p][0]),
                    Math.max(newInterval[1], intervals[p][1])};
            p++;
        }
        re.add(newInterval);
        while (p < len) {
            re.add(intervals[p]);
            p++;
        }
        return re.toArray(new int[re.size()][]);
    }

}
