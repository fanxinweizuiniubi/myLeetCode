package cyclicSort;

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {
        CyclicSort cyclicSort = new CyclicSort();
        cyclicSort.missingNumber(new int[]{3, 0, 1});
    }

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int[] record = new int[len + 1];
        Arrays.fill(record, -1);
        for (int i : nums) {
            record[i] = 1;
        }
        for (int i = 0; i < len + 1; i++) {
            if (record[i] == -1) {
                return i;
            }
        }
        return -1;
    }
}
