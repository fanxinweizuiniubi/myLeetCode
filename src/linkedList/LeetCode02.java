package linkedList;

public class LeetCode02 {
    public static void main(String[] args) {
        ListNode l10 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l10.next = l11;
        l11.next = l12;

        ListNode l20 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        l20.next = l21;
        l21.next = l22;

        ListNode re = addTwoNumbers(l10, l20);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) return null;
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        int jinwei = 0;
        int a = 0;
        int b = 0;
        while (null != l1 || null != l2) {
            if (null != l1) a = l1.val;
            else a = 0;
            if (null != l2) b = l2.val;
            else b = 0;
            int sum = a + b + jinwei;

            jinwei = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (null != l1)
                l1 = l1.next;
            if (null != l2)
                l2 = l2.next;

            if (jinwei == 1) {
                cur.next = new ListNode(jinwei);
            }
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
