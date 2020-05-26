package 基础练习;

import java.util.Scanner;

/**
 * Description：
 * 利用字母可以组成一些美丽的图形，下面给出了一个例子：
 *
 * ABCDEFG
 *
 * BABCDEF
 *
 * CBABCDE
 *
 * DCBABCD
 *
 * EDCBABC
 *
 * 这是一个5行7列的图形，请找出这个图形的规律，并输出一个n行m列的图形。
 *
 * @author jiaoqianjin
 * Date: 2020/4/16 15:46
 **/

public class 字母图形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(i == j) {
                    arr[i][j] = 'A' + 0;
                }else {
                    arr[i][j] = (char) ('A' + Math.abs(i - j));
                }
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("===============");
        String str = "ZYXWVUTSRQPONMLKJIHGFEDCBABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0;i<n;i++) {
            System.out.println(str.substring((25-i),(25-i+m)));
        }
    }

}
