package leetcode.tree;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/11/8 13:46
 **/

public class TreeNode {
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
