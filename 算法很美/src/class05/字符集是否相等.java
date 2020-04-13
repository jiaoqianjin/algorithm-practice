package class05;

import sun.security.util.Length;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 焦前进
 * @Date: 2020/4/4 15:09
 * @Description:
 * 询问两个串是否由相同的字符集生成
 **/
public class 字符集是否相等 {
    /**
     * 限制串的组成的字符时ASCII
     * @param s1
     * @param s2
     * @return
     */
    public static boolean check(String s1,String s2){
        int[] helper = new int[256];
        for (int i = 0; i < s1.length(); i++){
           char c = s1.charAt(i);
           if(helper[c] == 0){
               helper[c] = 1;
           }
        }
        for (int i = 0; i < s2.length(); i++){
            char c = s2.charAt(i);
            if(helper[c] == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 利用 HashMap
     * @param s1
     * @param s2
     * @return
     */
    public static boolean check2(String s1,String s2){
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            if(map.get(c) == null){
                map.put(c,1);
            }
        }
        for (int i = 0; i < s2.length(); i++){
            char c = s2.charAt(i);
            if(map.get(c) == null){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "aaasdfaff";
        String s2 = "aaasfac";
        System.out.println(check(s1,s2));
        System.out.println(check2(s1,s2));
    }
}
