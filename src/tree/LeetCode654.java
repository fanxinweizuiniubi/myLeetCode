package tree;

public class LeetCode654 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode treeNode = constructMaximumBinaryTree(nums);
        System.out.println(true);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length - 1);
    }
    private static TreeNode build(int[] nums,int lo,int hi){
        if(lo > hi) return null;
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for(int i = lo;i <= hi;i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums, lo, maxIndex - 1);
        root.right = build(nums, maxIndex + 1, hi);
        return root;
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}