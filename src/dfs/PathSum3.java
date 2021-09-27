package dfs;

import bfs.TreeNode;

public class PathSum3 {

    private int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        if (root.val == sum) res++;
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }

}
