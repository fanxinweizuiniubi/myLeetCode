package slidingWindow;


import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
 */
public class LongestKSubstr {

    public static void main(String[] args) {
        LongestKSubstr longestKSubstr = new LongestKSubstr();
        int aabacbebebe = longestKSubstr.longestKSubstr("aabacbebebe", 3);
        System.out.println(aabacbebebe);
    }

    public int longestKSubstr02(String s, int k) {
        Map<Character, Integer> charCountRecord = new HashMap<>();
        int max = -1, n = s.length(), start = 0;
        for (int end = 0; end < n; end++) {
            char c = s.charAt(end);
            charCountRecord.put(c, charCountRecord.getOrDefault(c, 0) + 1);
            while (charCountRecord.size() > k) {
                char left = s.charAt(start);
                charCountRecord.put(left, charCountRecord.get(left) - 1);
                if (charCountRecord.get(left) == 0) charCountRecord.remove(left);
                start++;
            }
            if (charCountRecord.size() == k) {
                max = Math.max(max, end - start + 1);
            }
        }
        return max;
    }

    public int longestKSubstr(String s, int k) {
        // code here
        char[] charArray = s.toCharArray();
        List<Character> charWindow = new ArrayList<>();
        int max = -1, n = s.length(), sum = 0, start = 0;
        for (int i = 0; i < n; i++) {
            charWindow.add(charArray[i]);
            if (distinctCharSize(charWindow) == k && sum > max) max = sum;
            sum++;
            while (distinctCharSize(charWindow) > k) {
                charWindow.remove(start);
                sum--;
                start++;
            }
        }
        return max;
    }

    public int distinctCharSize(List<Character> characterList) {
        Set<Character> distinctCharacters = new HashSet<>(characterList);
        return distinctCharacters.size();
    }

}
