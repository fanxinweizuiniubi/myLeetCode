package huawei;

public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        // 结点为空直接返回
        if(root == null){
            return null;
        }
        // 交换当前结点左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 遍历左子树
        invertTree(root.left);
        // 遍历右子树
        invertTree(root.right);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
