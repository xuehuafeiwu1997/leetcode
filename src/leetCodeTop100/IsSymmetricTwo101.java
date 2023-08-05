package leetCodeTop100;

import java.util.LinkedList;
import java.util.Queue;

import leetCodeTop100.common.TreeNode;

/**
 * 对称二叉树
 * 非递归解法
 *
 * 队列：offer入队，入队成功返回true，入队失败返回false
 *
 * @author xmy
 * @date 2023/2/25 5:23 下午
 */
public class IsSymmetricTwo101 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }

            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }

}
