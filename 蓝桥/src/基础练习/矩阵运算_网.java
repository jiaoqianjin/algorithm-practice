package 基础练习;

/**
* Description：
*
* @author jiaoqianjin
* Date: 2020/4/21 17:30
**/

import java.util.Scanner;

public class 矩阵运算_网 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();					//N阶
        int M = scanner.nextInt();					//M次幂
        int[][] a = new int[N][N];					//用二维数组a接收矩阵A
        int[][] c = new int[N][N];					//二维数组c接收矩阵A,并用于存储结果矩阵
        int i,j;

        //用二维数组a接收矩阵A
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                a[i][j] = c[i][j]= scanner.nextInt();
            }
        }

        //矩阵乘法
        if (M == 0) {								//当M=0时结果为单位矩阵
            for (i = 0; i < N; i++) {
                for(j = 0; j < N; j++) {
                    if (i == j) {
                        System.out.print(1 + " ");
                    } else {
                        System.out.print(0 + " ");
                    }
                }
                System.out.println();
            }
        } else if (M == 1) {						//当M=1时结果为原来的矩阵
            for (i = 0; i < N; i++) {
                for(j = 0; j < N; j++) {
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
        } else {									//当M>1时即为M个矩阵A相乘的结果。
            for (int m = 1; m < M; m++) {						//最外层控制M次幂，m从1开始或m<M -1都可以，不要乘多一次
                int[][] temp = new int[N][N];
                for (i = 0; i < N; i++) {						//i控制行
                    for (j = 0; j < N; j++) {					//j控制列
                        int sum = 0;
                        for (int k = 0; k < N; k++) {
                            sum += a[i][k] * c[k][j];
                        }
                        temp[i][j] = sum;
                    }
                }
                c = temp;
            }
            //打印结果矩阵C
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

