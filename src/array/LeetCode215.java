package array;

import java.util.Arrays;
import java.util.Random;

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
            int p = partition(arr, lo, hi);
            if (p == target) {
                return arr[p];
            } else if (target > p) {
                lo = p + 1;
            } else {
                hi = p - 1;
            }
        }
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = lo;
        int index = pivot + 1;
        for (int i = index; i <= hi; i++) {
            if (arr[pivot] > arr[i]) {
                swap(arr, index, i);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    public static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

}
