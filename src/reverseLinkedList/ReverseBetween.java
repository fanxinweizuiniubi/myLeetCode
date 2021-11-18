package reverseLinkedList;

import basic.ListNode;

/**
 * 192
 */
public class ReverseBetween {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        //ListNode l4 = new ListNode(4);
        //ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        //l3.next = l4;
        //l4.next = l5;
        ReverseBetween reverseBetween = new ReverseBetween();
        reverseBetween.reverseBetween(l1, 1, 2);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode start = null, betweenStart = head, cur = head, pre = null;
        int count = 0;
        while (count < right) {
            count++;
            if (count < left) {
                start = cur;
                cur = cur.next;
            }
            if (count == left) {
                betweenStart = cur;
            }
            if (count >= left) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
        }
        if (start != null) {
            start.next = pre;
        }
        betweenStart.next = cur;
        return start == null ? pre : head;
    }
}
