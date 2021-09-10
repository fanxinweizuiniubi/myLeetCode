package slowFast;

public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast.next != null ? slow.next : slow;
    }

}
