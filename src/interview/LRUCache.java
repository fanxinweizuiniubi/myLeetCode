package interview;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

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

    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;
    private Map<Integer, DLinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
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
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DLinkedNode oldTail = removeTail();
                cache.remove(oldTail.key);
                size--;
            }
        } else {
            dLinkedNode.val = value;
            moveToHead(dLinkedNode);
        }
    }

    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void removeNode(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void addToHead(DLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public DLinkedNode removeTail() {
        DLinkedNode tailPrev = tail.prev;
        removeNode(tailPrev);
        return tailPrev;
    }

}