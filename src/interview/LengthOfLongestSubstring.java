package interview;

import java.util.LinkedList;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int lo = 0, hi = 0, max = 1, len = s.length(), cur;
        if (len == 0) return 0;
        char[] charArray = s.toCharArray();
        LinkedList<Character> window = new LinkedList<>();
        while (hi < len) {
            while (window.contains(charArray[hi])) {
                window.remove(window.getFirst());
                lo++;
            }
            window.add(charArray[hi]);
            hi++;
            cur = hi - lo;
            if (cur > max) max = cur;
        }
        return max;
    }

}
