package com.mathsitics.stack;
import java.util.Stack;
public class LeetCode {
    LeetCode(){
        System.out.println(backspaceCompare("abc#","ac#b"));
        }
        public boolean backspaceCompare(String S, String T) {
            Stack<Character> stack1 = new Stack<>();
            Stack<Character> stack2 = new Stack<>();
            //遍历字符串中的每一个字符
            for (int i = 0; i < S.length(); i++) {
                //如果该元素是#，则将其弹出
                if (S.charAt(i) == '#') {
                        if (!stack1.empty()) {
                            stack1.pop();
                        }
                }else {
                    //如果不是，压进stack1中
                    stack1.push(S.charAt(i));
                }
            }
            //遍历字符串中的每一个字符
            for (int i = 0; i < T.length(); i++) {
                //如果该元素是#，则将其弹出
                if (T.charAt(i) == '#') {
                    if (!stack2.empty()) {
                        stack2.pop();
                    }
                }else {
                //如果不是，压进stack1中
                stack2.push(T.charAt(i));
                }
            }
            //判断两个栈中的元素个数是否相等
            if (stack1.size() != stack2.size()) {
                return false;
            }
            //如果两个栈中的元素都不为空，对两个栈中的每一个元素进行比较
            while (!stack1.empty()) {
                if (stack1.pop() != stack2.pop()) {
                    return false;
                }
            }
            return true;
        }
            public static void main (String[]args){
                new LeetCode();
            }

}
