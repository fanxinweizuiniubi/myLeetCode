package slidingWindow;

public class LeetCode209 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int min = minSubArrayLen1(7,nums);
        System.err.println(min);
    }

    private static int minSubArrayLen1(int s, int[] nums) {

        return 0;
    }

    // my solution 1
    private static int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0,j = 0,count = 0,min = Integer.MAX_VALUE,sum = 0;
        while(i < nums.length){
            count = 0;
            j = i;
            sum = 0;
            while(sum < s && j < nums.length){
                sum += nums[j];
                j++;
                count++;
            }
            if(count < min && sum >= s){
                min = count;
            }
            i++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
