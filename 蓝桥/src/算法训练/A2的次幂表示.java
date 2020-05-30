package 算法训练;

import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/5/28 17:38
 **/

public class A2的次幂表示 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(getRes(n));
    }

    private static String getRes(int n) {
        if(n == 0) {
            return "0";
        }
        String s = Integer.toBinaryString(n);  // 转换成二进制
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            char a = s.charAt(i);
            if(a == '1') {
                res.append("+2");
                if ((s.length()-1 - i) != 1) {
                    res.append("(");
                    res.append(getRes(s.length()-1 - i)) ;  // s.length()-1 - i 利用二进制的顺序得到 幂大小
                    res.append(")");
                }
            }
        }
        return res.toString().substring(1);
    }
}
