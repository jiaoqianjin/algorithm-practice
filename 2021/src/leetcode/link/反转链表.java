package leetcode.link;

import util.Util;

/**
 * Description：
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author jiaoqianjin
 * Date: 2021/11/13 13:42
 **/

public class 反转链表 {
    public ListNode reverseList(ListNode head) {
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

    public static void main(String[] args) {
        反转链表 listNode = new 反转链表();
        ListNode node = new ListNode();
        node.val = 1;
        ListNode node2 = new ListNode();
        node2.val = 2;
        node.next = node2;
        System.out.println(listNode.reverseList(node));
    }
}
