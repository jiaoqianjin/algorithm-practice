package 算法训练;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description：
 *
 * 给两组数，各n个。
 * 　　请调整每组数的排列顺序，使得两组数据相同下标元素对应相乘，然后相加的和最小。要求程序输出这个最小值。
 * 　　例如两组数分别为:1 3　　-5和-2 4 1
 *
 * 　　那么对应乘积取和的最小值应为：
 * 　　(-5) * 4 + 3 * (-2) + 1 * 1 = -25
 *
 * @author jiaoqianjin
 * Date: 2020/6/4 16:25
 **/

public class 最小乘积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 表示数据组数

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for (int j = 0; j < n; j++) {
                arr1[j] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                arr2[j] = sc.nextInt();
            }
            Arrays.sort(arr2);
            Arrays.sort(arr1);
            int res = 0;
            for (int m = 0; m < n; m ++) {
                res += arr1[m] * arr2[n - m - 1];
            }
            System.out.println(res);
        }
    }
}

