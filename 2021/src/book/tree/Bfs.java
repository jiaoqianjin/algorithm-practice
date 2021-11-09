package book.tree;

import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/11/7 21:29
 **/

public class Bfs {
    public List<Integer> breadFirstSearch(TreeNode treeNode) {
        List<Integer> res = new ArrayList<>();
        if (treeNode == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            /* 队列，先进先出，左节点先进，右节点后进，则出队左节点先出，右节点后出
             * 同一深度的按照先左后右的顺序遍历之后，才进行下一深度的遍历
             */
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
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
        Bfs bfs = new Bfs();
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val = 2;
        treeNode.right = treeNode1;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 3;
        treeNode1.left = treeNode2;
        List<Integer> integers = bfs.breadFirstSearch(treeNode);
        integers.forEach(System.out::println);
    }
}
