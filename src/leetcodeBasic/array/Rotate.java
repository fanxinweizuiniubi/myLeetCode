package leetcodeBasic.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Rotate {

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] arr = new int[]{1,2,2,2,2,1,4,5,6,6,5,4,3,3,3,4,4,5,6,6};
        rotate.rotate(arr, 12421);
        System.out.println(Arrays.toString(arr));

    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int[] cache = new int[k];
        int idx = 0;
        for (int i = len - k; i < len; i++) {
            cache[idx] = nums[i];
            idx++;
        }
        for (int i = len - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = cache[i];
        }
    }

}
