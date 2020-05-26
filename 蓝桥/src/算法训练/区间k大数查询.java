package 算法训练;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description：
 *给定一个序列，每次询问序列中第l个数到第r个数中第K大的数是哪个。
 *
 * 输入格式
 * 第一行包含一个数n，表示序列长度。
 *
 * 第二行包含n个正整数，表示给定的序列。
 *
 * 第三个包含一个正整数m，表示询问个数。
 *
 * 接下来m行，每行三个数l,r,K，表示询问序列从左往右第l个数到第r个数中，从大往小第K大的数是哪个。序列元素从1开始标号。
 *
 * @author jiaoqianjin
 * Date: 2020/5/26 17:19
 **/

public class 区间k大数查询 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 序列长度
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();  // 序列中的数
        }
        int m = sc.nextInt(); //表示询问的个数
        int[] res = new int[m]; // 存储询问的结果
        for (int i= 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            int[] helper = new int[r - l + 1]; // 存储 l - j 区间的数
            for (int j = 0; j < r - l + 1; j++) {
                helper[j] = arr[l + j - 1];
            }
            Arrays.sort(helper);
            res[i] = helper[helper.length - k]; // 得到l , k 区间中第 k 大的数
        }
        for(int i = 0 ; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
