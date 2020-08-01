package linkedList;

/**
* @Description 力扣138题
* @Author fanxinwei
* @Date 2020/7/1 15:36
**/
public class LeetCode138 {

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node result = copyRandomList(node1);
        System.out.println("l");
    }

    public static Node copyRandomList(Node head) {
        if(null == head) return null;
        Node cur = head;
        // 获得原链表长度
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        cur = head;
        Node dummy = new Node(0);
        Node rePtr = dummy;
        // 新建链表
        while(len != 0){
            dummy.next = new Node(cur.val);
            dummy = dummy.next;
            cur = cur.next;
            len--;
        }
        dummy = rePtr.next;
        // 处理随机指针
        cur = head;

        return rePtr.next;
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
