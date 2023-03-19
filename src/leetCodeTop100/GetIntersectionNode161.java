package leetCodeTop100;

import java.util.HashSet;

/**
 * 161. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * @author xmy
 * @date 2023/3/19 9:43 上午
 */
public class GetIntersectionNode161 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //解法一：使用哈希表来处理
        HashSet<ListNode> listNodeSet = new HashSet<>();
        while (headA != null) {
            listNodeSet.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (listNodeSet.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;

    }
}
