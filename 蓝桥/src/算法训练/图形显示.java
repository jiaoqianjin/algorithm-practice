package 算法训练;

import java.util.Scanner;

/**
 * Description：
 *编写一个程序，首先输入一个整数，例如5，然后在屏幕上显示如下的图形（5表示行数）：
 * 　　* * * * *
 * 　　* * * *
 * 　　* * *
 * 　　* *
 * 　　*
 * @author jiaoqianjin
 * Date: 2020/5/29 15:26
 **/

public class 图形显示 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = a; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
}
