package linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 力扣206题 链表翻转
 * @author: fanxinwei
 * @create: 2020-07-02 15:37
 **/
public class LeetCode206 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode re = reverse(l1);
        while(re != null){
            System.out.println(re.val);
            re = re.next;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 三指针翻转
    public static ListNode reverseList(ListNode head) {
        if(null == head) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        pre = cur;
        return pre;
    }

    // 头插法
    public static ListNode reverseList1(ListNode head) {
        if(null == head) return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = head.next;
        ListNode curNext = null;
        head.next = null;
        dummy.next = head;
        while(cur != null){
            curNext = cur.next;
            cur.next = head;
            head = cur;
            dummy.next = cur;
            cur = curNext;
        }
        return dummy.next;
    }

    // 栈实现
    public static ListNode reverseList2(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode ptr = new ListNode(-1);
        ListNode re = ptr;
        ListNode node = null;
        while(stack.size() != 0){
            node = stack.poll();
            ptr.next = node;
            ptr = node;
        }
        return re.next;
    }

}