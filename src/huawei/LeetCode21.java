package huawei;

public class LeetCode21 {

    public static void main(String[] args) {
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(2);
        ListNode n14 = new ListNode(4);
        ListNode n21 = new ListNode(1);
        ListNode n23 = new ListNode(3);
        ListNode n24 = new ListNode(4);
        n11.next = n12;
        n12.next = n14;

        n21.next = n23;
        n23.next = n14;

        ListNode ans = mergeTwoLists(n11, n21);
        System.out.println(ans);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l1 == null ? l2 : l1;
        return head.next;
    }

}
class ListNode{
    int val;
    ListNode next;

    ListNode(int val) { this.val = val; }
}