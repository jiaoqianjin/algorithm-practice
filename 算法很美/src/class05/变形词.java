package class05;

import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author 焦前进
 * @Date: 2020/4/2 17:54
 * @Description:
 * 变形词:两个串有相同的字符及数量组成 abc abc ,abc cba,aabcd bcada;
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *  * 这里规定大小写为不同字符，且考虑字符串中的空格。
 * 给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。
 * 保证两串的长度都小于等于5000。
 * 测试样例：
 * "Here you are","Are you here"
 * 返回：false
 **/
public class 变形词 {
    /**
     * 方法一：
     * 将两个字符串排序后判断是否相等
     * @param a
     * @param b
     * @return
     */
    public static boolean checkSam1(String a,String b){
        //判断两个字符串的长度是否相等，不相等直接返回
        int len1 = a.length();
        int len2 = b.length();
        if(len1 != len2){
            return false;
        }
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        Arrays.sort(charA);
        Arrays.sort(charB);
        return  Arrays.equals(charA,charB);
    }

    /**
     * 方法二
     * 利用辅助数组，将 a 数组的字符和辅助数组下标对应 ，该位置+1
     * b数组的数组和辅助数组下标对应，该位置-1，如果未负，返回false
     * 最后扫描辅助辅助，看是否存在不为0 的数，存在，返回false
     * @param a
     * @param b
     * @return
     */
    public static boolean checkSam2(String a,String b){
        int[] helper = new int[128];
        //利用辅助数组，将 a 数组的字符和辅助数组下标对应 ，该位置+1
        for (int i = 0; i < a.length(); i++){
            int c = a.charAt(i);
            helper[c]++;
        }
        //b数组的数组和辅助数组下标对应，该位置-1，如果未负，返回false
        for (int i = 0; i < b.length(); i++){
            int c = b.charAt(i);
            if(helper[c] < 0){
                return false;
            }else {
                helper[c]--;
            }
        }
        //最后扫描辅助辅助，看是否存在不为0 的数，存在，返回false
        for (int i = 0; i < helper.length; i++){
            if(helper[i] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "i love you";
        String b = "i love you";
        long now = new Date().getTime();
        System.out.println(checkSam1(a,b));
        long last1 = new Date().getTime();
        System.out.println(last1-now);
        System.out.println(checkSam2(a,b));
        long last2 = new Date().getTime();
        System.out.println(last2-last1);
    }
}
