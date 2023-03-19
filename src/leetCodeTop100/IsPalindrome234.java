package leetCodeTop100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 234.回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * @author xmy
 * @date 2023/3/19 7:13 下午
 */
public class IsPalindrome234 {

    public boolean isPalindrome(ListNode head) {
        //参考：另一种解法：炫技一样 https://leetcode.cn/problems/palindrome-linked-list/solution/kuai-man-zhi-zhen-fan-zhuan-lian-biao-on-pf80/

        //转换为数组的思想
        List<Integer> arr = new ArrayList<>();
        ListNode currentNode = head;
        //将其复制为数组
        while (currentNode != null) {
            arr.add(currentNode.val);
            currentNode = currentNode.next;
        }
        for (int i = 0; i <= arr.size() / 2 ; i++) {
            if (arr.get(i) != arr.get(arr.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
