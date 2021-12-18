package tree;

import java.util.LinkedList;

public class FindTreeNode {

    private TreeNode result;
    private boolean isExist;

    public static void main(String[] args) {
        // init the tree
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        A.left= B;
        A.right = C;
        B.left= D;
        B.right = E;
        C.left= F;
        C.right = G;
        System.out.println("show me the tree");
        FindTreeNode findTreeNode = new FindTreeNode();
        LinkedList<TreeNode> trace = new LinkedList();
        findTreeNode.isExist(A, 5, trace);
        System.out.println("done");
    }

    public void isExist(TreeNode root, int val, LinkedList<TreeNode> trace) {

    }

}
