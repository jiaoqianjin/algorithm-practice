package 算法训练;

import java.util.Scanner;

/**
 * Description：
 *      编写一个程序，输入一个字符串（长度不超过20），然后把这个字符串内的每一个字符进行大小写变换，
 *      即将大写字母变成小写，小写字母变成大写，然后把这个新的字符串输出。
 * 　　 输入格式：输入一个字符串，而且这个字符串当中只包含英文字母，不包含其他类型的字符，也没有空格。
 * 　　输出格式：输出经过转换后的字符串。
 * @author jiaoqianjin
 * Date: 2020/5/28 16:20
 **/

public class 字符串大小写转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i ++) {
            char num = str.charAt(i);
            if(num >= 65 && num <= 90) { // 如果当前字符为大写,转成小写
                String big = String.valueOf(num).toLowerCase();
                sb.append(big);
            } else {
                String big = String.valueOf(num).toUpperCase();
                sb.append(big);
            }
        }
        System.out.println(sb.toString());
    }
}
