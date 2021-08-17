package shopee;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int capacity;
    private int size;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int _capacity) {
        size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
        capacity = _capacity;
    }

    public int get(int key) {
        DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode == null) {
            return -1;
        }
        moveToHead(dLinkedNode);
        return dLinkedNode.value;
    }

    public void put(int key, int value) {
        DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addNodeToHead(newNode);
            ++size;
            if (size > capacity) {
                DLinkedNode tailNode = removeTailNode();
                cache.remove(tailNode.key);
                --size;
            }
        } else {
            dLinkedNode.value = value;
            moveToHead(dLinkedNode);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNodeToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addNodeToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private DLinkedNode removeTailNode() {
        DLinkedNode tailPrev = tail.prev;
        removeNode(tailPrev);
        return tailPrev;
    }

}
