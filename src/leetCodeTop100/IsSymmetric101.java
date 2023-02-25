package leetCodeTop100;

import leetCodeTop100.common.TreeNode;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 使用递归方法
 *
 * @author xmy
 * @date 2023/2/25 11:00 上午
 */
public class IsSymmetric101 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        return t1.val == t2.val && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

}
