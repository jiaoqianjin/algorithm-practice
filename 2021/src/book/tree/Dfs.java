package book.tree;

import leetcode.tree.二叉树的中序遍历;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description：深度优先搜索
 *
 * @author jiaoqianjin
 * Date: 2021/11/7 20:54
 **/

public class Dfs {

    /**
     * 功能描述: 深度优先搜索
     * DFS 就是先尽可能的达到当前遍历路径能够达到的最长路径，达到该路径终点之后，回溯
     * 从原来已经遍历过顶点处开始新分支遍历
     *
     * @param treeNode 待遍历分支
     * @return 遍历结果
     * @author jiaoqianjin
     * @date 2021/11/7
     */
    public List<Integer> deptFirstSearch(TreeNode treeNode) {
        List<Integer> res = new ArrayList<>();
        if (treeNode == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            // 获取节点
            TreeNode node = stack.pop();
            // 栈，先入后出，所以右节点先入栈，左节点后入栈。出栈顺序则为先左后右
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            res.add(node.val);
        }
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Dfs dfs = new Dfs();
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val = 2;
        treeNode.right = treeNode1;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 3;
        treeNode1.left = treeNode2;
        List<Integer> integers = dfs.deptFirstSearch(treeNode);
        integers.forEach(System.out::println);
    }
}
