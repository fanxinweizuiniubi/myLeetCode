package company.byteDance;

import java.util.LinkedList;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring len = new LengthOfLongestSubstring();
        int re = len.lengthOfLongestSubstring(" ");
        System.out.println(re);
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), max = 0;
        if (len == 0) return 0;
        char[] charArray = s.toCharArray();
        LinkedList<Character> window = new LinkedList<>();
        for (Character c : charArray) {
            while (window.contains(c)) {
                window.removeFirst();
            }
            window.add(c);
            if (window.size() > max) max = window.size();
        }
        return max;
    }
    
}
