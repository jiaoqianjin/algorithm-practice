package leetcode.codetop;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/12/7 16:25
 **/

public class codeTop18_二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 如果 q,p 为根节点，则公共祖先为根节点
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        // 如果p,q在左子树，则公共祖先在左子树查找
        if (findNode(root.left, p) && findNode(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // 如果q,p在右子树，则公共祖先在右子树查找
        if (findNode(root.right, p) && findNode(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // 如果p,q 分属两侧，则公共祖先为根节点
        return root;
    }

    /**
     * 功能描述: 判断节点c是否在 以root为节点的二叉树上
     */
    private boolean findNode(TreeNode root, TreeNode c) {
        if (root == null) {
            return false;
        }
        if (root.val == c.val) {
            return true;
        }
        return findNode(root.left, c) || findNode(root.right, c);
    }

    /**
     * 功能描述:
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    /**
     * 功能描述: 复习，准备小红书 12.22
     * 解题思路：首先判断pq在左子节点还是右子节点，但是分属两侧，之后
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 如果pq其中一个为根节点，则公共祖先肯定为根节点
        if (p == root || q == root) {
            return root;
        }
        // 如果p,q在左子树，则公共祖先在左子树查找
        if (findNode2(root.left, p) && findNode2(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // 如果p,q 在右子树，则公共祖先在右子树查找
        if (findNode2(root.right, p) && findNode2(root.right, q)) {
            return lowestCommonAncestor(root.right, q, p);
        }
        // 如果p, q分属两侧，则当前节点为最近公共结点
        return root;
    }

    /**
     * 功能描述: 判断节点在左子树还是右子树
     */
    private boolean findNode2(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root.val == node.val) {
            return true;
        }
        return findNode(root.left, node) || findNode(root.right, node);
    }

    /**
     * 功能描述: 复习，准备小红书 12.22
     * 解题思路：
     * ■ 终止条件
     * 1 当越过叶子节点，则直接返回null;
     * 2 当root 等于 p，q，则直接返回root;
     * ■ 递推工作
     * 1 开启递归左子节点，返回值记为left;
     * 2 开启递归右子节点，返回值记为right;
     * ■ 返回值：根据left和right,可展开为四种情况
     * 1 当left和right同时为空，说明 root的左右子树都包含p，q，返回null;
     * 2 当left和right同时不为空，说明p,q在root的异侧，此时root为最近公共祖先，返回root;
     * 3 当left为空，right不为空，说明 p,q都不在root的左子树中，直接返回right
     * ○ p,q其中一个在root的右子树，此时right 指向 p
     * ○ p,q两节点都在root的右子树，此时的right指向最近公共祖先节点
     * 4 当left不为空，right为空，同3
     */
    public TreeNode getRootNode(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = getRootNode(root.left, p, q);
        TreeNode right = getRootNode(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
