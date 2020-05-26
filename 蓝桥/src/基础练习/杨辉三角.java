package 基础练习;

import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/4/16 17:07
 **/

public class 杨辉三角 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        System.out.println(1);
        for (int i = 1; i < n; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
            System.out.print(arr[i][0] + " ");
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(arr[i][i]);
        }
    }

}
