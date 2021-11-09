package leetcode.tree;

import com.sun.org.apache.regexp.internal.RE;

import java.lang.reflect.WildcardType;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description：
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * @author jiaoqianjin
 * Date: 2021/11/9 13:36
 **/

public class 对称二叉树 {
    /**
     * 功能描述: 递归
     *
     * @param root 待检测二叉树
     * @return boolean 是否平衡
     * @author jiaoqianjin
     * @date 2021/11/9
     */
    public boolean isSymmetric(TreeNode root) {
        return checkTree(root.left, root.right);
    }

    private boolean checkTree(TreeNode m, TreeNode n) {
        if (m == null || n == null) {
            return m == null && n == null;
        }
        return m.val == n.val
                && checkTree(m.left, n.right)
                && checkTree(m.right, n.left);
    }

    /**
     * 功能描述: 迭代
     *
     * @param root 待检测二叉树
     * @return boolean 是否平衡
     * @author jiaoqianjin
     * @date 2021/11/9
     */
    public boolean isSymmetric2(TreeNode root) {
        return checkTree2(root.left, root.right);
    }

    private boolean checkTree2(TreeNode left, TreeNode right) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()) {
            left = queue.poll();
            right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);

        }
        return true;
    }


}
