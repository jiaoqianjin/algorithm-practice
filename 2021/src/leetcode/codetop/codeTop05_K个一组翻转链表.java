package leetcode.codetop;


/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/11/20 13:39
 **/

public class codeTop05_K个一组翻转链表 {
    /**
     * 功能描述:
     * 初步思路：如果K值小于等于链表长度，则进行翻转，如果剩余链表长度小于K,则不作改变
     *
     * @param head
     * @param k
     * @return ListNode
     * @author jiaoqianjin
     * @date 2021/11/20
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 定义虚拟头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 初始化pre和end,pre: 待翻转链表的上一节点，end：反转后链表的尾结点
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 循环K次，找到需要翻转的链表结尾
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 如果end==null,则翻转的链表长度小于K,不翻转
            if (end == null) {
                break;
            }
            // 记录下一段链表的头结点，方便与本段链表连接
            ListNode next = end.next;
            // 断开链表
            end.next = null;
            // 记录本段的头结点
            ListNode start = pre.next;
            // 翻转
            pre.next = reverseNode(start);

            // 翻转后，头结点变到最后，与下一段链表相连
            start.next = next;
            // pre初始化为下段链表的结点
            pre = start;

            end = pre;
        }
        return dummy.next;

    }

    /**
     * 功能描述: 翻转链表
     *
     * @param head 头结点
     * @author jiaoqianjin
     * @date 2021/11/20
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
}
