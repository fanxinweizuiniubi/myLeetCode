package everyDay;

/**
 * https://leetcode-cn.com/problems/ugly-number/
 */
public class LeetCode263 {

    public static void main(String[] args) {
        int n = -1;
        boolean isUgly = isUgly(n);
        System.out.println(isUgly);
    }

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] primeArr = {2, 3, 5};
        for (int i : primeArr) {
            while (n % i == 0) {
                n = n / i;
            }
        }
        return n == 1;
    }

}
