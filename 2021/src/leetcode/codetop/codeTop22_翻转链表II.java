package leetcode.codetop;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/12/23 20:02
 **/

public class codeTop22_翻转链表II {
    /**
     * 功能描述: 在需要反转的区间里，每遍历到一个节点，就让这个新节点来到反转部分的起始位置
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode temp;
        for (int i = 0; i < right - left; i++) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummyNode.next;

    }

    private ListNode reverseNode(ListNode head) {
        ListNode pre = new ListNode();
        ListNode temp;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
