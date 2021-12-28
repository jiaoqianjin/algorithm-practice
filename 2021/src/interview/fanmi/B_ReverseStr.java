package interview.fanmi;

/**
 * Description：实现reverse string
 *
 * @author jiaoqianjin
 * Date: 2021/12/25 13:52
 **/

public class B_ReverseStr {
    /**
     * 功能描述: 方法一，时间复杂度O(n),时间复杂度O(n)
     */
    public static String reverse1(String s) {
        int n = s.length();
        char[] charArr = new char[n];
        for (int i = 0; i < n; i++) {
            charArr[i] = s.charAt(n - 1 - i);
        }
        return new String(charArr);
    }
    /**
     * 功能描述: 方法二，利用StringBuilder中的翻转方法
     */
    public static String reverse2(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "i love you";
        System.out.println(reverse1(s));
        System.out.println(reverse2(s));
    }
}
