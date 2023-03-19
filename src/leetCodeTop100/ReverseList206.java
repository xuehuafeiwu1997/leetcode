package leetCodeTop100;

import java.util.Stack;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author xmy
 * @date 2023/3/19 10:41 上午
 */
public class ReverseList206 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode listNode = reverseList_1(l1);
        System.out.println(listNode);

    }

    public static ListNode reverseList(ListNode head) {
        //能想到栈是一个很大的进步，组装的思想需要好好想想
        if (head == null) {
            return head;
        }
        //栈先进后出
        Stack<ListNode> listNodeStack = new Stack<>();
        ListNode start = new ListNode(0, null);
        ListNode temp = start;
        while (head != null) {
            listNodeStack.push(head);
            head = head.next;
        }
        while (!listNodeStack.isEmpty()) {
            temp.next = listNodeStack.pop();
            temp = temp.next;
        }
        //这一行必须要加，不然的话死循环，因为你在使用栈的时候进行组装，还把原先的指针组装了进去
        temp.next = null;
        return start.next;
    }

    public static ListNode reverseList_1(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
