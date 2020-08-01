package linkedList;

public class LeetCode61 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode re = rotateRight(l1,2);
        while(re != null){
            System.out.println(re.val);
            re = re.next;
        }
    }

    // 第一版
    public static ListNode rotateRight(ListNode head, int k) {
        if(null == head) return null;
        if(null == head.next || k == 0) return head;
        ListNode cur = head;
        // 获取链表长度
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        if(k % len == 0) return head;
        cur = head;
        // 获取断链位置
        int pos = len - k % len;
        // 断链
        while(pos != 1){
            cur = cur.next;
            pos--;
        }
        ListNode newHead = cur.next;
        ListNode re = newHead;
        cur.next = null;
        while(newHead.next != null) {
            newHead = newHead.next;
        }
        // 连接链表
        newHead.next = head;
        return re;
    }

}
