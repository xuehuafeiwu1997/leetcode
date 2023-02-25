package leetCodeTop100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetCodeTop100.common.TreeNode;

/**
 * 二叉树中序遍历：基于栈的实现的解法
 * @author xmy
 * @date 2023/2/25 10:45 上午
 */
public class InorderTraversalTwo94 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, treeNode1, null);
        TreeNode root = new TreeNode(1, null, treeNode2);
        List<Integer> integers = inorderTraversal(root);
        System.out.println(integers);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur =cur.getLeft();
            } else {
                cur = stack.pop();
                list.add(cur.getVal());
                cur = cur.getRight();
            }
        }
        return list;
    }
}
