package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Connect {
    public Node connect(Node root) {
        if (null == root) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double levelNum = queue.size();
            List<Node> cache = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                Node poll = queue.poll();
                cache.add(poll);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            for (int i = 0; i < cache.size() - 1; i++) {
                cache.get(i).next = cache.get(i + 1);
            }
        }
        return root;
    }
}
