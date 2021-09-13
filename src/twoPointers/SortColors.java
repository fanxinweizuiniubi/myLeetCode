package twoPointers;

public class SortColors {

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = new int[]{0,0,0,0,1,1};
        sortColors.sortColors(nums);
        System.out.println(nums);
    }

    public void sortColors(int[] nums) {
        int l = 0, len = nums.length;
        for (int target = 0; target <= 1; target++) {
            while (l < len && nums[l] == target) l++;
            for (int r = l + 1; r < len; r++) {
                if (nums[r] == target) {
                    swap(nums, l, r);
                    l++;
                }
            }
        }
    }

    private void swap (int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
