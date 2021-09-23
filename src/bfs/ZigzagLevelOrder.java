package bfs;

import java.util.*;

public class ZigzagLevelOrder {
    public static void main(String[] args) {
        List<Integer> reverse = Arrays.asList(1,2,3);

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> cache = new ArrayList<>();
            List<Integer> resNodeList = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                cache.add(poll);
                if (res.size() % 2 == 0) {
                    resNodeList.add(poll.val);
                } else {
                    resNodeList.add(0, poll.val);
                }
            }
            res.add(resNodeList);
            for (TreeNode node : cache) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
