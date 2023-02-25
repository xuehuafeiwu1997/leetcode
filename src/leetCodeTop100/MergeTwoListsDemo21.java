package leetCodeTop100;

/**
 *  21.合并两个有序链表
 *  将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author xmy
 * @date 2023/2/23 8:50 下午
 */
public class MergeTwoListsDemo21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(l1, l2);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

        while(l1 != null) {
            System.out.println("l1: " + l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            System.out.println("l2: " + l2.val);
            l2 = l2.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
