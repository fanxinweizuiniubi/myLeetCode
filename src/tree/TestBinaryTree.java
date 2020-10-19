package tree;

public class TestBinaryTree {

    /**
     *             A
     *           |  \
     *          B    C
     *         / \  / \
     *        D  E F   G
     */
    public static void main(String[] args) {
        // init the tree
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        A.leftNode = B;
        A.rightNode = C;
        B.leftNode = D;
        B.rightNode = E;
        C.leftNode = F;
        C.rightNode = G;
        System.out.println("show me the tree");
        InnerClass innerClass = new InnerClass();
        // 前序遍历
        postTraverse(A);
    }

    public static void postTraverse(TreeNode root){
        if(root != null){
            System.out.print(root.getCurrent());
            postTraverse(root.leftNode);
            postTraverse(root.rightNode);
        }
    }

    static class TreeNode{
        private String current;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(String current) {
            this.current = current;
        }

        public String getCurrent() {
            return current;
        }

        public void setCurrent(String current) {
            this.current = current;
        }

        public TreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }
    }

}
class InnerClass{
    private String name;
}
