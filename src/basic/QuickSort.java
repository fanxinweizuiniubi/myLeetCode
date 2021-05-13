package basic;

import java.util.Arrays;

/**
 * 快排
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int partitionIndex = partition(arr, lo, hi);
            quickSort(arr, partitionIndex + 1, hi);
            quickSort(arr, lo, partitionIndex - 1);
        }
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = lo;
        int index = pivot + 1;
        for (int i = index; i <= hi; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        // 因为当前index位置之前位置的值都为小于pivot的，而前一个正好是中间的位置，所以把枢纽和index-1交换，可以使得枢纽正好排到正中央
        swap(arr, index - 1, pivot);
        // index-1的位置正好为枢纽的位置
        return index - 1;
    }

    public static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

}


