package dfs;

import bfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * problem 113
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        PathSum pathSum = new PathSum();
        pathSum.pathSum(t1, 3);
    }

    public List<List<Integer>> pathSumRecursive(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> currentRes = new LinkedList<>();
        dfs(root, res, currentRes, targetSum);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, List<Integer> currentRes, int sum) {
        if (root == null) return;
        currentRes.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new LinkedList<>(currentRes));
        } else {
            dfs(root.left, res, currentRes, sum - root.val);
            dfs(root.right, res, currentRes, sum - root.val);
        }
        currentRes.remove(currentRes.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        int sum = 0;
        List<TreeNode> visited = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        sum += root.val;
        visited.add(root);
        if (root.right == null && root.left == null) addResult(res, stack, sum, targetSum);
        while (!stack.isEmpty()) {
            if (stack.peek().left != null && !visited.contains(stack.peek().left)) {
                stack.push(stack.peek().left);
                visited.add(stack.peek());
                sum += stack.peek().val;
                if (stack.peek().left == null && stack.peek().right == null) {
                    addResult(res, stack, sum, targetSum);
                }
            } else if (stack.peek().right != null && !visited.contains(stack.peek().right)) {
                stack.push(stack.peek().right);
                visited.add(stack.peek());
                sum += stack.peek().val;
                if (stack.peek().left == null && stack.peek().right == null) {
                    addResult(res, stack, sum, targetSum);
                }
            } else {
                TreeNode pop = stack.pop();
                sum -= pop.val;
            }
        }
        return res;
    }

    private void addResult(List<List<Integer>> res, Stack<TreeNode> stack, int sum, int targetSum) {
        if (sum != targetSum) return;
        List<Integer> resNode = new ArrayList<>();
        for (TreeNode treeNode : stack) {
            resNode.add(treeNode.val);
        }
        res.add(resNode);
    }
}
