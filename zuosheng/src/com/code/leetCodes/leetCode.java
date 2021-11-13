package com.code.leetCodes;

import java.util.Stack;

//LeetCode 234 回文链表
public class leetCode {
    public class LeetNode {
      int val;
      LeetNode next;
      LeetNode(int x) { val = x; }
  }
    leetCode(){

    }
    //利用栈stack，将链表的前半部分存在栈中，pop出来的值与后半部分进行比较
    Stack<Integer> stack = new Stack<>();
    public boolean isPalindrome(LeetNode head) {
        LeetNode fast = head;
        LeetNode slow = head;

        while (fast.next != null || fast.next.next != null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null ){
            slow = slow.next;
        }
        while (slow != null){
            if(slow.val != stack.pop()){
                return false;
            }
            slow = slow.next;
        }
        return true;


    }
    public static void main(String[] args) {
        new leetCode();
    }
}
