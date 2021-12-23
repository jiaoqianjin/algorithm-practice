package leetcode.codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description：二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * @author jiaoqianjin
 * Date: 2021/11/29 16:13
 **/

public class codeTop12_二叉树的层序遍历 {
    /**
     *功能描述: 广度优先搜索
     * @param root 根节点
     * @return 返回层序遍历的节点值
     * @author jiaoqianjin
     * @date 2021/11/29
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 如果为空，直接返回
        if (root == null) {
            return res;
        }
        // 声明队列，存入节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 存储每一层的节点值
            ArrayList<Integer> list = new ArrayList<>();
            int currentSize = queue.size();
            // 每执行一次while就会遍历一层的数据
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        codeTop12_二叉树的层序遍历 test = new codeTop12_二叉树的层序遍历();
        TreeNode node = new TreeNode();
        node.val = 3;
        TreeNode left = new TreeNode();
        left.val = 4;
        TreeNode right = new TreeNode();
        right.val = 5;
        node.left = left;
        node.right = right;
        System.out.println(test.levelOrder(node));
    }
}
