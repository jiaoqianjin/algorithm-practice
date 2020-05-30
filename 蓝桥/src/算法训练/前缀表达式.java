package 算法训练;

import sun.reflect.generics.tree.ArrayTypeSignature;

import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/5/28 16:28
 **/

public class 前缀表达式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sign = sc.next();
        int a = sc.nextInt();
        int b = sc.nextInt();
        switch (sign) {
            case "+" :
                System.out.println(a + b);
                break;
            case "-" :
                System.out.println(a - b);
                break;
            case "*" :
                System.out.println(a * b);
                break;
            case "/" :
                System.out.println(a / b);
                break;
        }
    }
}
