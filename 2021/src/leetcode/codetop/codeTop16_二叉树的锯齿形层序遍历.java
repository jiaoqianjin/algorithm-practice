package leetcode.codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description：二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * @author jiaoqianjin
 * Date: 2021/12/4 13:42
 **/

public class codeTop16_二叉树的锯齿形层序遍历 {
    /**
     * 功能描述: 解题思路
     * <p>
     * 广度优先搜索，层序遍历，每层加入队列的顺序相反
     *
     * @param root 待遍历二叉树
     * @return 锯齿形遍历数据
     * @author jiaoqianjin
     * @date 2021/12/4
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int temp = queue.size();
            for (int i = 0; i < temp; i++) {
                TreeNode node = queue.poll();
                if (count % 2 == 1) {
                    list.addFirst(node.val);
                } else {
                    list.addLast(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
            res.add(list);
        }
        return res;
    }
}
