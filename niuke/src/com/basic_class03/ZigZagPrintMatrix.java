package com.basic_class03;

/**
 * @Auther:焦前进
 * @Data:2020/2/20
 * @Description:
 * “之”字形打印矩阵
 * 【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这
 * 个矩阵，例如： 1 2 3 4 5 6 7 8 9 10 11 12
 * “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，
 * 8，12
 * 【要求】 额外空间复杂度为O(1)。
 */
public class ZigZagPrintMatrix {
    public static void printMatrixZigZag(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix.length - 1;
        boolean formUP = false; //斜向上还是斜向下
        while (tR != endR + 1){
            prientLevel(matrix,tR,tC,dR,dC,formUP);
            // 向右走，如果达到最后一列，向下
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dR = dR == endR ? dR : dR + 1;
            dC = dR == endR ? dC + 1 :dC;
            formUP = !formUP;
        }
        System.out.println();
    }

    private static void prientLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);

    }
}
