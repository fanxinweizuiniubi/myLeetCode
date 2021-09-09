package twoPointers;

import java.util.Arrays;

public class SortedSquares {

    public static void main(String[] args) {
        SortedSquares sortedSquares = new SortedSquares();
        int[] ints = sortedSquares.sortedSquares(new int[]{-7,-3,-2,-1,0});
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] re = new int[n];
        int p1 = 0, p2 = n - 1;
        for (int r = n - 1; r >= 0; r--) {
            if (Math.abs(nums[p1]) > Math.abs(nums[p2])) {
                re[r] = nums[p1] * nums[p1];
                p1++;
            } else {
                re[r] = nums[p2] * nums[p2];
                p2--;
            }
        }
        return re;
    }

}
