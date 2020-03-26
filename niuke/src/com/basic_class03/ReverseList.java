package com.basic_class03;

import java.util.Date;

/**
 * @Auther:焦前进
 * @Data:2020/2/20
 * @Description:
 * 反转单向和双向链表
 * 【题目】 分别实现反转单向链表和反转双向链表的函数。
 * 【要求】 如果链表长度为N，时间复杂度要求为O(N)，额外空间
 * 复杂度要求为O(1)
 */
public class ReverseList {
    /*
    初始化链表
     */
    public static class Node{
        public int value;
        public Node next;

        public Node(int data){
            this.value = data;
        }
    }

    /*
        翻转单向链表
     */
    public static  Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
