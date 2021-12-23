package leetcode.codetop;

import java.util.HashSet;
import java.util.Set;

/**
 * Description：环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiaoqianjin
 * Date: 2021/11/27 13:51
 **/

public class codeTop10_环形链表 {
    /**
     * 功能描述: 思路1：快慢指针
     * 利用快慢指针的方式，如果最后慢指针追上快指针，证明有环
     *
     * @param head 头结点
     * @return boolean 是否有环
     * @author jiaoqianjin
     * @date 2021/11/27
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 慢指针
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick) {
            if (quick == null || quick.next == null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }

    /**
     * 功能描述: 思路二：hash存入
     * 如果存入失败证明重复节点，有环
     *
     * @param head 头结点
     * @return boolean 是否有环
     * @author jiaoqianjin
     * @date 2021/11/27
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
