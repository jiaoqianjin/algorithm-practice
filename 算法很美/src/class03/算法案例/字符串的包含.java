package class03.算法案例;

/**
 * @Author 焦前进
 * @Date: 2020/3/30 16:17
 * @Description:
 * Case02串B是否包含串A的全部字符：
 * 判断字符串A中的字符是否全部出现在字符串B中（大众点评笔试题）
 **/

import java.util.Arrays;
public class 字符串的包含 {
    public static boolean check1(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            if (s2.indexOf(a) == -1){
                return false;
            }
        }
        return true;
    }
    public static boolean check2(String s1, String s2) {
        char[] s2_arr = s2.toCharArray();
        Arrays.sort(s2_arr);
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            int index = Arrays.binarySearch(s2_arr, a);
            if (index < 0)
                return false;
        }
        return true;
    }

}