package leetcode.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * Description：3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author jiaoqianjin
 * Date: 2021/11/16 13:38
 **/

public class codeTop03_无重复字符的最长子串 {
    /*
        解题思路：维护两个指针，右指针不断向右移动，如果右指针与左指针指向value相同，则计算两指针之间的距离
        同时左指针向右移动一位
        存在问题：如果没有和第一位字符重复，那么中间有重复字符会忽略
        解决思路：利用哈希存储字符及字符存在的位置，如果当前字符重复，则计算距离，并将指针移动至重复字符位置
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        byte[] bytes = s.getBytes();
        int left = 0;
        int right = 1;
        int res = 0;
        Map<Byte, Integer> map = new HashMap<>();
        map.put(bytes[left], left);
        while (left <= right && right < bytes.length) {
            if (map.containsKey(bytes[right])) {
                res = Math.max((right - left), res);
                Integer pre = map.get(bytes[right]);
                if (pre >= left) {
                    left = map.get(bytes[right]) + 1;
                }
                map.remove(bytes[right]);
            } else {
                map.put(bytes[right], right);
                right++;
            }
        }
        return Math.max((right - left), res);
    }

    /**
     * 功能描述: 寻找无重复字符的最长子串
     *
     * @param s 待遍历字符串
     * @return int 返回最长子串长度
     * @author jiaoqianjin
     * @date 2021/11/16
     */
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            map.put(c, end);
        }
        return max;
    }

    public static void main(String[] args) {
        codeTop03_无重复字符的最长子串 test = new codeTop03_无重复字符的最长子串();
        String s = "abcabcbb";
        System.out.println(test.lengthOfLongestSubstring2(s));
    }
}
