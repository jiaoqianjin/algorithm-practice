package 算法训练;

import java.util.Scanner;

/**
 * Description：
 *
 * 　输入两个矩阵，分别是m*s，s*n大小。输出两个矩阵相乘的结果。
 *
 * @author jiaoqianjin
 * Date: 2020/6/5 15:42
 **/

public class 矩阵乘法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[][] A = new int[m][s];
        int[][] B = new int[s][n];
        for (int i = 0; i < m ; i ++) {
            for (int j = 0; j < s ; j ++) {
                A[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < s ; i ++) {
            for (int j = 0; j < n ; j ++) {
                B[i][j] = sc.nextInt();
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m ; i ++) {
            for (int j = 0; j < n ; j ++) {
                for (int k = 0; k < s ; k ++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        for (int i = 0; i < m ; i ++) {
            for (int j = 0; j < n ; j ++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
