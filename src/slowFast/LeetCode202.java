package slowFast;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 */
public class LeetCode202 {

    public static void main(String[] args) {
        LeetCode202 leetCode202 = new LeetCode202();
        boolean b = leetCode202.isHappy1(222321312);
        System.out.println(b);
    }

    // HashSet 方法判断
    public boolean isHappy(int n) {
        String str = String.valueOf(n);
        // 拆分 string 并计算平方和 --- 判断是否和为 1 --- 不为 1 继续计算
        int sum;
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += Math.pow(Integer.parseInt(String.valueOf(str.charAt(i))), 2);
            }
            str = String.valueOf(sum);
            if (sum == 1) return true;
            if (set.contains(sum)) return false;
            else set.add(sum);
            System.out.println(sum);
        }
    }

    // 获得下一个数
    private int getNext(int n){
        int totalSum = 0;
        while(n > 0){
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    // 快慢指针
    public boolean isHappy1(int n){
        int slow = n;
        int fast = getNext(n);
        while(fast != 1 && fast != slow){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

}
