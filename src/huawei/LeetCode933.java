package huawei;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode933 {

    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        int a = rc.ping(1);
        int b = rc.ping(100);
        int c = rc.ping(3001);
        int d = rc.ping(3002);
        System.out.println(" ");
    }

}
class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList();
    }

    public int ping(int t) {
        queue.add(t);
        while(queue.peek() < t - 3000){
            queue.poll();
        }
        return queue.size();
    }
}
