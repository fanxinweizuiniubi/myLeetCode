package slidingWindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode03 {

    public static void main(String[] args) {
        String s = "pwwkew";
        int max = lengthOfLongestSubstring1(s);
        System.out.println(max);
    }

    // 两个循环
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) return 0;
        char[] arr = s.toCharArray();
        // i -> 某一个元素
        // j -> i的下一个元素
        int i = 0, j = i + 1;
        int count = 1,max = count;
        // 每新增一个元素，判断它是否与已存在元素重复
        // 不重复j++ 重复i++ ; j = i + 1
        boolean isRep;
        while(i != len - 1){
            isRep = false;
            for(int k = i;k < j;k++){
                if(arr[k] == arr[j]) {
                    isRep = true;
                    break;
                }
            }
            if(isRep){
                count = 1;
                i++;
                if(i != len - 1) j = i + 1;
            }else{
                count++;
                if(count > max) max = count;
                if(j == len - 1) break;
                    j++;
            }
        }
        return max;
    }

    // 模拟队列思路
    public static int lengthOfLongestSubstring1(String s) {
        int len = s.length();
        if(len == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < len; i++) {
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
        }
        return max;
    }
}
