package slowFast;

import java.util.HashSet;
import java.util.Set;

public class LeetCode141 {

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
        l5.next = l2;
        LeetCode141 leetCode141 = new LeetCode141();
        Boolean b = leetCode141.hasCycle(l1);
        System.out.println(b);
    }

    // 判断是否有环 ---> 快慢指针
    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        // 慢指针每次走一步，快指针每次走两步，如果它们相遇，则说明有环
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (null == fast || null == fast.next){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    // 哈希表
    public boolean hasCycle01(ListNode head){
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null){
            if(nodesSeen.contains(head)){
                return true;
            }else{
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}