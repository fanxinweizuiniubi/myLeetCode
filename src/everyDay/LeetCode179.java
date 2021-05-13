package everyDay;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/largest-number/
 */
public class LeetCode179 {

    public static void main(String[] args) {
        int[] nums = {3,300,34,5,9};
        String ans = largestNumber(nums);
        System.out.println(ans);
    }

    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = "" + nums[i];
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b, sb = b + a ;
            return sb.compareTo(sa);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : ss) sb.append(s);
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

}
