package com.code.leetCodes;
import java.util.Scanner;

/**
 * @Auther:焦前进
 * @Data:2020/2/3
 * @Description: 求1+2+3+...+n的值。
 */
public class ListSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 1 ; i <= n ;i ++ ){
            sum = sum + i;
        }
        System.out.println(sum);
    }
}
