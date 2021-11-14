package dfs;

import bfs.TreeNode;

import java.math.BigDecimal;

/**
 * 我醉了...我始终搞不懂递归
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
