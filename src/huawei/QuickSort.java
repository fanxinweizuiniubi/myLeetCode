package huawei;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,4};
        QuickSort qs = new QuickSort();
        qs.quickSort(nums,0,nums.length-1);
        System.out.println(nums);
    }

    public void quickSort(int[] nums,int lo,int hi){
        if(lo < hi) {
            int index = partition(nums, lo, hi);
            quickSort(nums, lo, index - 1);
            quickSort(nums, index + 1, hi);
        }
    }

    public int partition(int[] nums,int lo,int hi){
        int pivot = nums[lo];
        while(lo < hi){
            while(lo < hi && nums[hi] >= pivot) hi--;
            nums[lo] = nums[hi];
            while(lo < hi && nums[lo] <= pivot) lo++;
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }

}
