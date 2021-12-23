package leetcode.codetop;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/12/2 13:59
 **/

public class codeTop01_反转链表 {
    /**
     * 功能描述: 解题思路，
     * 记录当前节点的上一节点，以及下一节点
     * 翻转当前指上一节点
     *
     * @param head 待反转头结点
     * @return 翻转后链表
     * @author jiaoqianjin
     * @date 2021/12/2
     */
    private ListNode reverseNode(ListNode head) {
        ListNode pre = null;
        ListNode temp;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    /**
     * 功能描述: 递归 nk+1 的下一节点指向nk nk.next.next = nk
     * 时间负杂度，O(N)
     * 空间复杂度，O(N)
     *
     * @param head 待翻转链表
     * @return leetcode.codetop.ListNode
     * @author jiaoqianjin
     * @date 2021/12/23
     */

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}
