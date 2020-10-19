package string;

/**
 * Z 字型变换
 */
public class LeetCode06 {

    public static int MY_SIZE = 10;

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        String res = convert(s, 4);

        System.out.println(res);
    }

    public static String convert(String s, int numRows) {
        if (null == s) return s;
        // 获得跳跃数量
        int skip = numRows - 1 + numRows / 2 + 1;

        // 第一行位置为从头开始分别加上skip
        return null;
    }

}
