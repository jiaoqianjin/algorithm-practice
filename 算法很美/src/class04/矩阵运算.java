package class04;

import util.Util;

import java.util.Scanner;

/**
 * @Author 焦前进
 * @Date: 2020/4/2 15:01
 * @Description:
 **/
public class 矩阵运算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] A = new int[M][N];
        int[][] B = new int[M][N];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                A[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                B[i][j] = sc.nextInt();
            }
        }
        // A + 2X = B ，求 X
        int[][] X = getX(A,B,M,N);
        Util.printMatrix(X);

        long[][] m1 = {
                {1,0,3,-1},
                {2,1,0,2}
        };
        long[][] m2 = {
                {4,1,0},
                {-1,1,3},
                {2,0,1},
                {1,3,4}
        };
        Util.printMatrix1(matrixMultiply(m1,m2));
    }

    /**
     * x = 1/2(b-a)
     * @param a
     * @param b
     * @param m
     * @param n
     * @return
     */
    private static int[][] getX(int[][] a, int[][] b,int m,int n) {
        int[][] X = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                X[i][j] = (b[i][j]-a[i][j])/2;
            }
        }
        return X;
    }

    /**
     * (m * n)的矩阵 * （n * p)的矩阵
     * 得到的结果为 （m * p) 的矩阵
     * @param m1
     * @param m2
     * @return
     */
    private static long[][] matrixMultiply(long[][] m1,long[][]m2){
        final int n = m1.length;
        final int m = m1[0].length;
        if(m != m2.length) throw new IllegalArgumentException();
        final int p = m2[0].length;
        long[][] result = new long[n][p];//新矩阵的行数为m1的行数，m2的列数

        for(int i = 0; i < n; i++){ //m1 的行
            for(int j = 0; j < p; j++){ // m2 的列
                for (int k = 0; k < m; k++){ //m1 的行与m2的列相乘求和
                    result[i][j] +=m1[i][k] * m2[k][j];
                }
            }
        }
        return result;
    }
}
