package leetcode.codetop;

import java.util.*;

/**
 * Description：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author jiaoqianjin
 * Date: 2021/12/6 13:51
 **/

public class codeTop17_有效的括号 {
    /**
     * 功能描述: 解题思路
     * 遍历字符串，将字符存入栈中，遇到相同的弹出
     * 如果最后栈不为空，或栈中元素不够，则为false
     *
     * @param s 待判定字符串
     * @return boolean 是否有效
     * @author jiaoqianjin
     * @date 2021/12/6
     */
    public boolean isValid(String s) {
        // 如果字符串长度为奇数，直接返回
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        // 利用map判断括号的类型，左括号入栈，右括号进行匹配
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 判断当前字符括号类型,如果为左括号，则入栈，如果为右括号，则进行匹配判断
            if (map.containsKey(c)) {
                // 如果栈为空，或者第一个右括号和最后一个左括号不匹配，则返回false
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        // 判断最后栈是否为空，为空则true，否则false
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        codeTop17_有效的括号 test = new codeTop17_有效的括号();
        String s = "()]{}";
        System.out.println(test.isValid(s));
    }
}
