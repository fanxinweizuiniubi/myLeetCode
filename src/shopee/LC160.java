package shopee;

import java.util.ArrayList;
import java.util.List;

public class LC160 {

    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        // 交点
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;
        l3.next = l7;
        l7.next = l8;
        l4.next = l5;
        l5.next = l6;
        l5.next = l3;*/
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode intersectionNode = getIntersectionNode01(l1, l2);
        System.out.println(intersectionNode);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> linkRecord = new ArrayList<>();
        ListNode res = null;
        while (headB != null) {
            linkRecord.add(headB);
            headB = headB.next;
        }
        while (headA != null) {
            if (linkRecord.contains(headA)) {
                res = headA;
                break;
            }
            headA = headA.next;
        }
        return res;
    }

    public static ListNode getIntersectionNode01(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

}
