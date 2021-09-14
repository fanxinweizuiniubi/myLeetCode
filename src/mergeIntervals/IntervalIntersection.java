package mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

    public static void main(String[] args) {
        IntervalIntersection intervalIntersection = new IntervalIntersection();
        int[][] firstList = {{0,2}, {5,10}, {13,23}, {24,25}};
        int[][] secondList = {{1,5}, {8,12}, {15,24}, {25,26}};
        intervalIntersection.intervalIntersection(firstList, secondList);
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int secondLen = secondList.length, firstLen = firstList.length;
        int p1 = 0, p2 = 0;
        List<int[]> res = new ArrayList<>();
        while (p1 < firstLen && p2 < secondLen) {
            int[] first = firstList[p1];
            int[] second = secondList[p2];
            int startMax = Math.max(first[0], second[0]);
            int endMin = Math.min(first[1], second[1]);
            // overlap
            if (startMax <= endMin) {
                res.add(new int[]{startMax, endMin});
            }
            if (first[1] == endMin) p1++;
            if (second[1] == endMin) p2++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
