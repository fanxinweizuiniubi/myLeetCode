package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (null == root) return 0;
        int sum = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) return sum;
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            sum++;
        }
        return sum;
    }
}
