package leetcode.codetop;

/**
 * Description：合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author jiaoqianjin
 * Date: 2021/11/29 13:36
 **/

public class codeTop11_合并两个有序链表 {
    /**
     * 功能描述: 迭代
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     * @author jiaoqianjin
     * @date 2021/11/29
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode prev = res;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;
        return res.next;
    }

    /**
     * 功能描述: 递归
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     * @author jiaoqianjin
     * @date 2021/11/29
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val <= list2.val) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
        }
    }

    // 复习，准备小红书
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        // 声明结果
        ListNode res = new ListNode(-1);
        ListNode pre = res;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        // 当其中一个链表为空的时候，直接追加另一个链表
        pre.next = list1 == null ? list2 : list1;
        return res.next;
    }

    // 复习，准备小红书，递归
    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists3(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists3(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        codeTop11_合并两个有序链表 test = new codeTop11_合并两个有序链表();
        ListNode list1 = new ListNode();
        list1.val = 1;
        ListNode list12 = new ListNode();
        list12.val = 2;
        ListNode list13 = new ListNode();
        list13.val = 4;
        list1.next = list12;
        list12.next = list13;
        ListNode list2 = new ListNode();
        list2.val = 1;
        ListNode list22 = new ListNode();
        list22.val = 3;
        ListNode list23 = new ListNode();
        list23.val = 4;
        list2.next = list22;
        list22.next = list23;
        ListNode node = test.mergeTwoLists3(list1, list2);
        System.out.println(node);

    }
}
