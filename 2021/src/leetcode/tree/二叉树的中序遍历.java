package leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/11/7 15:58
 **/

public class 二叉树的中序遍历 {
    /**
     * 功能描述: 递归 中序遍历，左->中->右
     *
     * @param root 待遍历的二叉树
     * @return java.util.List<java.lang.Integer>
     * @author jiaoqianjin
     * @date 2021/11/7
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        // 遍历左子节点
        inorder(root.left, res);
        res.add(root.val);
        // 遍历右子节点
        inorder(root.right, res);
    }

    /**
     * 功能描述: 迭代
     *
     * @param root 待遍历二叉树
     * @return
     * @author jiaoqianjin
     * @date 2021/11/7
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();

        while (root != null || !stk.isEmpty()) {
            // 循环查找左子树，一直到左子树不存在
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            // 当左子树为null,则输出根节点->右节点
            root = stk.pop();
            res.add(root.val);
            // 走右节点，重复循环
            root = root.right;
        }
        return res;
    }
    public static void main(String[] args) {
        二叉树的中序遍历 tree = new 二叉树的中序遍历();
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val = 2;
        treeNode.right = treeNode1;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 3;
        treeNode1.left = treeNode2;
        System.out.println(tree.inorderTraversal(treeNode));
    }
}
