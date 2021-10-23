package twoHeaps;

import java.util.*;

public class MedianFinder {

    private Queue<Integer> small = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private Queue<Integer> large = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        // assure the median is on the last of large priorityQueue
        large.offer(num);
        small.offer(large.poll());
        if (small.size() > large.size()) large.offer(small.poll());
    }

    public double findMedian() {
        return large.size() > small.size() ? large.peek() : (small.peek() + large.peek()) / 2.0;
    }
}
