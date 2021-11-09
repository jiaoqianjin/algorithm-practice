package leetcode.tree;

import java.util.Stack;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/11/8 13:45
 **/

public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左子树的深度
        int leftDepth = maxDepth(root.left);
        // 计算右子树的深度
        int rightDepth = maxDepth(root.right);
        // 返回深度较大者
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        二叉树的最大深度 tree = new 二叉树的最大深度();
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val = 2;
        treeNode.right = treeNode1;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 3;
        treeNode1.left = treeNode2;
        System.out.println(tree.maxDepth(treeNode));
    }
}
