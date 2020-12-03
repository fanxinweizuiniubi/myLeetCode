package array;

import java.util.Arrays;
import java.util.Random;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class LeetCode215 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        LeetCode215 leetCode215 = new LeetCode215();
        int kthLargest = leetCode215.findKthLargest(arr, k);
        System.out.println(kthLargest);
    }

    /**
     * 在主方法中直接返回len-k位置的数。
     * <p>
     * 快速选择方法：如果当前返回下标和目标下标一致，则直接返回。返回下标比目标下标小，则去右侧子区间快速选择，返回下标比目标下标大，则去左边子区间快速选择。
     * <p>
     * 随机划分取数方法：为了减小快排因顺序问题而导致的时间复杂度提升，采用随机数的方式去获取下一个选定的数，并将这个选定给的数放到数组的最后面。
     * <p>
     * 划分子区间方法中，将比当前选定数小的数都放到它的前面，最后将选中的枢纽放到所有比他小的数的右侧第一个。最后返回枢纽的位置，即右侧第一个。
     */

    Random random = new Random();

    public int findKthLargest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, arr.length - k);
    }

    public int quickSelect(int[] arr, int lo, int hi, int index) {
        int pIndex = randPartition(arr, lo, hi);
        if (pIndex == index) {
            return arr[index];
        } else {
            return pIndex < index ? quickSelect(arr, pIndex + 1, hi, index) : quickSelect(arr, lo, pIndex - 1, index);
        }
    }

    public int randPartition(int[] arr, int lo, int hi) {
        int ranNum = random.nextInt(hi - lo + 1) + lo;
        swap(arr, ranNum, hi);
        return partition(arr, lo, hi);
    }

    public int partition(int[] arr, int lo, int hi) {
        int pivotVal = arr[hi], move = lo - 1;
        for (int cur = lo; cur < hi; cur++) {
            if (arr[cur] < pivotVal) {
                swap(arr, ++move, cur);
            }
        }
        swap(arr, move + 1, hi);
        return move + 1;
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}
