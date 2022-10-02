package ListDemo;

/**
 * 反转链表
 *
 * @author xmy
 * @date 2022/4/30 9:40 下午
 */
public class reverseListDemo {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; //前指针节点
        ListNode curr = head; //当前指针节点
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while(curr != null) {
            ListNode nextTemp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
            curr.next = prev; //将当前节点指向它前面的节点
            prev = curr; //前指针后移
            curr = nextTemp; //当前指针后移
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);

    }


}



class ListNode<T>  {
    T val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode(T val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
