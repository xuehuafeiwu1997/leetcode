package leetCodeTop100;

import java.util.ArrayList;
import java.util.List;

import leetCodeTop100.common.TreeNode;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * @author xmy
 * @date 2023/2/25 10:25 上午
 */
public class InorderTraversal94 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, treeNode1, null);
        TreeNode root = new TreeNode(1, null, treeNode2);
        List<Integer> integers = inorderTraversal(root);
        System.out.println(integers);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midPrint(list, root);
        return list;
    }

    public static void midPrint(List<Integer> list, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        midPrint(list, treeNode.getLeft());
        list.add(treeNode.getVal());
        midPrint(list, treeNode.getRight());
    }
}


