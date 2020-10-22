package binarySearch;

public class TestBinarySearch {

    public static void main(String[] args) {
        TestBinarySearch t = new TestBinarySearch();
        int[] nums = {1,2,3,4,5};
        int index = t.binarySearch(nums, 9);
        //int val = nums[index];
        System.out.println(index);
    }

    public int binarySearch(int[] nums,int key){
        // 获取中间值，比他大去右边，比他小，去左边
        int lo = 0,hi = nums.length-1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(key > nums[mid]){
                lo = mid + 1;
            } else if (key < nums[mid]){
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
