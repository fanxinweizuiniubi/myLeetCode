package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (null == root) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0, avg = 0;
            double levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            avg = sum / levelNum;
            res.add(avg);
        }
        return res;
    }

}
