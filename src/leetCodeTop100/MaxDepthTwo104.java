package leetCodeTop100;

import java.util.LinkedList;
import java.util.Queue;

import leetCodeTop100.common.TreeNode;

/**
 * 计算二叉树的最大深度
 * 非递归解法
 *
 * @author xmy
 * @date 2023/2/25 6:04 下午
 */
public class MaxDepthTwo104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            level++;


            for (int i = 0; i < queue.size(); i++) {
                queue.remove();
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
        }
        return level;
    }
}
