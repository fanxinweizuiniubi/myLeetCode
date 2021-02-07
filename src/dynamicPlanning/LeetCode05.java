package dynamicPlanning;

/**
 * longest-palindromic-substring
 */
public class LeetCode05 {

    public static void main(String[] args) {
        LeetCode05 leetCode05 = new LeetCode05();
        String str = "babad";
        String longestPalindrome = leetCode05.longestPalindrome(str);
        System.out.println(longestPalindrome);
    }

    /**
     * given string: babad
     * result: bab
     */
    public String longestPalindrome(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int right = 1; right < len; right++) {
            for (int left = 0; left < right; left++) {
                if (charArray[left] != charArray[right]) {
                    dp[left][right] = false;
                } else {
                    if (right - left < 3) {
                        dp[left][right] = true;
                    } else {
                        // 最左和最右相等，那么当前坐标看它里面的是否相等
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    begin = left;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
