package leetCodeTop100;

/**
 * 19. 删除链表的第n个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @author xmy
 * @date 2023/5/7 9:06 上午
 */
public class RemoveNthFromEnd19 {

    /**
     * 第一种解法，两次循环，第一次循环记录链表的总大小，之后一次的循环，按照倒数的节点个数删除对应的节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //先找出链表的总大小，然后根据n去删除
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        int targetIndex = 0;
        ListNode prev = null;
        ListNode curr1 = head;
        while(curr1 != null) {
            if (targetIndex == (count - n)) {
                //删除的是头节点的情况下
                if(prev == null) {
                    head = head.next;
                    return head;
                }
                prev.next = curr1.next;
                break;
            } else {
                prev = curr1;
                curr1 = curr1.next;
            }
            targetIndex++;
        }
        return head;
    }


    /**
     * 解法二：快慢指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        return dummy.next;
    }

}
