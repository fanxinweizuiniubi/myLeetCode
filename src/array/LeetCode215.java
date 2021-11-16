package array;

import basic.QuickSort;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class LeetCode215 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int nthNum = findNthNum(arr, 2);
        System.out.println(nthNum);
    }

    public static int findNthNum(int[] arr, int N) {
        int len = arr.length;
        int hi = len - 1;
        int lo = 0;
        int target = len - N + 1 - 1;
        while (true) {
            int p = QuickSort.partition(arr, lo, hi);
            if (p == target) {
                return arr[p];
            } else if (target > p) {
                lo = p + 1;
            } else {
                hi = p - 1;
            }
        }
    }

}
