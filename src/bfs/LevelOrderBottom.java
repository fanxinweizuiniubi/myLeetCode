package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> upToBottom = new ArrayList<>();
        List<List<Integer>> bottomToUp = new ArrayList<>();
        if (root == null) return upToBottom;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> cache = new ArrayList<>();
            List<Integer> resNodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                cache.add(poll);
                resNodeList.add(poll.val);
            }
            upToBottom.add(resNodeList);
            for (TreeNode node : cache) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        for (int i = upToBottom.size() - 1; i >= 0; i--) {
            bottomToUp.add(upToBottom.get(i));
        }
        return bottomToUp;
    }
}
