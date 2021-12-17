package company.huawei;

import java.util.ArrayList;
import java.util.List;

public class LeetCode234 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        //ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        // n4.next = n5;
        boolean palindrome = isPalindrome(n1);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int lo = 0;
        int hi = list.size() - 1;
        while(lo < hi){
            if(!list.get(lo).equals(list.get(hi))){
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

}
