package dfs;

import bfs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumNumbers {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        SumNumbers sumNumbers = new SumNumbers();
        sumNumbers.sumNumbers(t1);
    }

    public int sumNumbersDiscuss(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) return sum;
        if (root.left == null && root.right == null) return sum * 10 + root.val;
        return dfs(root.left, sum * 10 + root.val) + dfs(root.right, sum * 10 + root.val);
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        List<TreeNode> visited = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        visited.add(root);
        if (root.left == null && root.right == null) sum += sumCurrent(stack);
        while (!stack.isEmpty()) {
            if (stack.peek().left != null && !visited.contains(stack.peek().left)) {
                stack.push(stack.peek().left);
                visited.add(stack.peek());
                if (stack.peek().left == null && stack.peek().right == null) {
                    sum += sumCurrent(stack);
                }
            } else if (stack.peek().right != null && !visited.contains(stack.peek().right)) {
                stack.push(stack.peek().right);
                visited.add(stack.peek());
                if (stack.peek().left == null && stack.peek().right == null) {
                    sum += sumCurrent(stack);
                }
            } else {
                stack.pop();
            }
        }
        return sum;
    }

    private int sumCurrent(Stack<TreeNode> stack) {
        StringBuilder sum = new StringBuilder();
        for (TreeNode treeNode : stack) {
            sum.append(treeNode.val);
        }
        return Integer.parseInt(sum.toString());
    }
}
