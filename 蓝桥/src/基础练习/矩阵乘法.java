package 基础练习;

import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/4/21 16:05
 **/

public class 矩阵乘法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 矩阵阶数
        int N = sc.nextInt();
        // 要求的幂数
        int M = sc.nextInt();
        int[][] A = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                A[i][j] = sc.nextInt();
            }
        }
        if(M == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        System.out.print(1 + " ");
                    } else {
                        System.out.print(0 + " ");
                    }
                }
                System.out.println();
            }
        } else if(M == 1) {
            printMatrix(A);
        } else {
            printMatrix(matrixMultiply(A,A,M));
        }

    }
    /**
     * (m * n)的矩阵 * （n * p)的矩阵
     * 得到的结果为 （m * p) 的矩阵
     * @param m1
     * @param m2
     * @return
     */
    private static int[][] matrixMultiply(int[][] m1,int[][] m2,int m3) {
        final int n = m1.length;
        final int m = m1[0].length;
        if (m != m1.length) throw new IllegalArgumentException();
        final int p = m2[0].length;

        for (int c = 1; c < m3; c++) {
            int[][] result = new int[n][p];//新矩阵的行数为m1的行数，m2的列数
            for (int i = 0; i < n; i++) { //m1 的行
                for (int j = 0; j < p; j++) { // m2 的列
                    int sum = 0;
                    for (int k = 0; k < m; k++) { //m1 的行与m2的列相乘求和
                        sum += m1[i][k] * m2[k][j];
                    }
                    result[i][j] = sum;
                }

            }
            m2 = result;
        }
        return m2;
    }
    private static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
