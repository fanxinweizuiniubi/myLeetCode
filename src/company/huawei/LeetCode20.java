package company.huawei;

import java.util.LinkedList;

public class LeetCode20 {

    public static void main(String[] args) {
        String str = "{[]}";
        boolean valid = isValid(str);
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || c != stack.pop()) {
                // 栈为空说明只有右括号没有左括号，第二个条件不符合说明两个括号不匹配
                return false;
            }
        }
        return stack.isEmpty();
    }

}
