package interview;

import java.util.HashMap;
import java.util.Map;

public class LRUCachePractice {

    private int size;
    int capacity;
    private Map<Integer, DLinkedNode> cache;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCachePractice(int capacity) {
        size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode == null) {
            return -1;
        }
        moveToHead(dLinkedNode);
        return dLinkedNode.val;
    }

    public void put(int key, int value) {
        DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
            size++;
            if (size > capacity) {
                DLinkedNode tailNode = removeTail();
                cache.remove(tailNode.key);
                size--;
            }
        } else {
            dLinkedNode.val = value;
            moveToHead(dLinkedNode);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private DLinkedNode removeTail() {
        DLinkedNode prev = tail.prev;
        removeNode(prev);
        return prev;
    }

    class DLinkedNode {
        int key;
        int val;
        DLinkedNode next;
        DLinkedNode prev;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
