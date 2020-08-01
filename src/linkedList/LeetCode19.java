package linkedList;

/**
 * @program: hzdc-products-irb-cms
 * @description: 力扣第19题
 * @author: fanxinwei
 * @create: 2020-06-29 14:13
 **/
public class LeetCode19 {

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
        ListNode resultNode = removeNthFromEnd(l1,2 );
        while(l1 != null){
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 只有一个头结点或者头结点为空
        if(null == head || null == head.next) return null;
        // 保留头结点
        ListNode lenCursor = head;
        ListNode deleteCursor = head;
        // 获取当前链表长度
        int len = 0;
        while(lenCursor != null){
            len++;
            lenCursor = lenCursor.next;
        }
        // 获取应删除节点位置 len - n
        int deletePosition = len - n;
        if(n > len) return null;
        if(len == n){
            return head.next;
        }
        // 删除这个节点
        // 获得删除节点的前一个位置
        while(deletePosition != 1){
            deleteCursor = deleteCursor.next;
            deletePosition--;
        }
        deleteCursor.next = deleteCursor.next.next;
        return head;
    }

}