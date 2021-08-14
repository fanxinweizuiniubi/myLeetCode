package linkedList;

import java.util.List;

public class LeetCode02 {
    public static void main(String[] args) {
        int[] a1 = {9, 8, 7};
        int[] a2 = {2, 3};
        ListNode l10 = create(a1);
        ListNode l20 = create(a2);

        ListNode re = addTwoNumbers(l10, l20);
        System.out.println(re);
    }

    public static ListNode create(int[] arr) {
        ListNode head = null;
        for (int i : arr) {
            ListNode p = new ListNode(i);
            if (head == null) {
                head = p;
            } else {
                p.next = head;
                head = p;
            }
        }
        return head;
    }

    // 987 + 23 = 1010
    // 7->8->9
    // 3->2
    // 0->1->0->1
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
