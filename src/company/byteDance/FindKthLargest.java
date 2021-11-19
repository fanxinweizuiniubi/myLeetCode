package company.byteDance;

import java.util.Random;

public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest f = new FindKthLargest();
        int[] nums = {3,2,1,5,6,4};
        f.select(nums, 2);
    }

    public int select(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    swap(nums, i, j);
                }
            }
        }
        return nums[k - 1];
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return quickSelect(nums, 0, len - 1, len - k);
    }

    public static int quickSelect(int[] nums, int lo, int hi, int target) {
        int partition = randomPartition(nums, lo, hi);
        if (partition == target) {
            return nums[target];
        } else {
            if (target > partition)
                return quickSelect(nums, partition + 1, hi, target);
            else
                return quickSelect(nums, lo, partition - 1, target);
        }
    }

    public static int randomPartition(int[] nums, int lo, int hi) {
        Random random = new Random();
        int r = random.nextInt(hi - lo + 1) + lo;
        swap(nums, r, hi);
        return partition(nums, lo, hi);
    }

    public static int partition(int[] nums, int lo, int hi) {
        int pivot = lo;
        int index = pivot + 1;
        for (int i = index; i <= hi; i++) {
            if (nums[pivot] > nums[i]) {
                swap(nums, index, i);
                index++;
            }
        }
        swap(nums, pivot, index - 1);
        return index - 1;
    }

    public static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
