package shopee;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int _val) {
        val = _val;
        next = null;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
