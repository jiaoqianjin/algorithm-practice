package leetcode.tree;

import java.io.Writer;

/**
 * Description：相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * @author jiaoqianjin
 * Date: 2021/11/7 19:52
 **/

public class 相同的树 {
    /**
     * 功能描述: 深度优先搜索
     * 解题思路
     * 首先判断两树是否都为空，如果是则为true
     * 如果其中一个为空则为false
     * 如果都不为空则判断左子树和右子树
     *
     * @param p 树p
     * @param q 树q
     * @return boolean
     * @author jiaoqianjin
     * @date 2021/11/7
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
