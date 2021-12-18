package company.byteDance;

import basic.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<TreeNode> cache = new LinkedList<>();
        cache.add(root);
        List<Integer> le = new LinkedList<>();
        for (TreeNode node : cache) {
            le.add(node.val);
        }
        result.add(le);
        while (!cache.isEmpty()) {
            int size = cache.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = cache.poll();
                if (poll != null) {
                    if (poll.left != null) cache.add(poll.left);
                    if (poll.right != null) cache.add(poll.right);
                }
            }
            if (!cache.isEmpty()) {
                List<Integer> level = new LinkedList<>();
                for (TreeNode node : cache) {
                    level.add(node.val);
                }
                result.add(level);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(result.get(i));
            }
        }
        return result;
    }

}

