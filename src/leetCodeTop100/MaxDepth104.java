package leetCodeTop100;

import leetCodeTop100.common.TreeNode;

/**
 * @author xmy
 * @date 2023/2/25 5:34 下午
 */
public class MaxDepth104 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, treeNode1, null);
        TreeNode root = new TreeNode(1, null, treeNode2);
        int i = maxDepth(root);
        System.out.println("最大高度为:" + i);
    }

    public static int maxDepth(TreeNode root) {
        int maxLength = 0;
        if (root == null) {
            return maxLength;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
