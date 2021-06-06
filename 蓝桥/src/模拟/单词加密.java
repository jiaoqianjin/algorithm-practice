package 模拟;

import sun.applet.Main;

import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/10/10 21:58
 **/

public class 单词加密 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String help = "abcdefgfijklmnopqrstuvwxyz";
        char[] c = new char[26];
        for (int i = 0; i < help.length(); i++) {
            c[i] = help.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            int aaa = 0;
            for (int j = aaa; j < c.length; j++) {
                if (c1 == c[j]) {
                    if (c1 == 'x') {
                        sb.append('a');
                    } else if (c1 == 'y') {
                        sb.append('b');
                    } else if (c1 == 'z') {
                        sb.append('c');
                    } else {
                        sb.append(c[j + 3]);
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
