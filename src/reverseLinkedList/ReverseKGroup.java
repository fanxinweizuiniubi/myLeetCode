package reverseLinkedList;

import basic.ListNode;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dmy = new ListNode(-1);
        dmy.next = head;
        ListNode tail = head;
        int n = 0;
        for (ListNode i = head;i != null;n++, i = i.next);
        for (ListNode prev = dmy; n >= k; n-=k) {
            for (int i = 1; i < k; i++) {
                ListNode next = tail.next.next;
                tail.next.next = prev.next;
                prev.next = tail.next;
                tail.next = next;
            }
            prev = tail;
            tail = tail.next;
        }
        return dmy.next;
    }
}
