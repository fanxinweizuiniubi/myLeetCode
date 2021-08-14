package array;

public class LeetCode05 {

    public static void main(String[] args) {
        String str = "aba";
        LeetCode05 leetCode05 = new LeetCode05();
        String subString = leetCode05.findLongestSubString(str);
        System.out.println(subString);
    }

    /**
     * 使用动态规划来解决此题
     * 状态的变化可以根据子串来推出当前串是否为回文串
     * 采用双循环，两层循环是为了将整个字符串遍历全，外层循环代表右边的界限，里层循环代表里面的界限
     * 如果两个位置的字符不相等，那么当前二维坐标为false
     * 如果当前两个位置坐标小于3，那么可以直接将当前坐标设为true
     * 否则，当前坐标布尔值根据子串推断
     * 如果当前串是回文串，且长度大于最大值，那么将当前初始位置记录，并将当前最大值记录
     * 最后返回的时候，返回起始值+最大值的子串
     */
    public String findLongestSubString(String str){
        int len = str.length();
        if(len < 2){
            return str;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        // 自己到自己肯定是回文串
        for(int i = 0;i < len;i++){
            dp[i][i] = true;
        }
        for(int right = 1;right < len;right++){
            for(int left = 0;left < right;left++){
                if(str.charAt(left) != str.charAt(right)){
                    dp[left][right] = false;
                } else {
                    if (right - left < 3){
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }
                if(dp[left][right] && (right - left + 1 > maxLen)){
                    maxLen = right - left + 1;
                    begin = left;
                }
            }
        }
        return str.substring(begin,begin + maxLen);
    }

}
