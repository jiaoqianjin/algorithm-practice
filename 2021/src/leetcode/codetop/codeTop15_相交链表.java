package leetcode.codetop;

import java.util.HashSet;
import java.util.Set;

/**
 * Description：相交链表
 * 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * @author jiaoqianjin
 * Date: 2021/12/3 13:37
 **/

public class codeTop15_相交链表 {
    /**
     * 功能描述: 解题思路
     *
     * @param headA 链表A
     * @param headB 链表B
     * @return leetcode.codetop.ListNode
     * @author jiaoqianjin
     * @date 2021/12/3
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 功能描述: 解题思路
     * 你走过我的路，我走过你的路，如果我们俩的路有重复的路，那么一定会在相交点相遇
     *
     * @param headA 链表A
     * @param headB 链表B
     * @return leetcode.codetop.ListNode
     * @author jiaoqianjin
     * @date 2021/12/3
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
