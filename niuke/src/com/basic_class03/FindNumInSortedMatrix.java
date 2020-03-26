package com.basic_class03;

/**
 * @Auther:焦前进
 * @Data:2020/2/20
 * @Description:
 * 在行列都排好序的矩阵中找数
 * 【题目】 给定一个有N*M的整型矩阵matrix和一个整数K，
 * matrix的每一行和每一 列都是排好序的。实现一个函数，判断K
 * 是否在matrix中。 例如： 0 1 2 5 2 3 4 7 4
 * 4 4 8 5 7 7 9 如果K为7，返回true；如果K为6，返
 * 回false。
 * 【要求】 时间复杂度为O(N+M)，额外空间复杂度为O(1)
 */
public class FindNumInSortedMatrix {
    public static boolean findNum(int[][] matrix,int k){
        int row = 0; // 定义行
        int col = matrix[0].length - 1;
        while (row < matrix.length && col > -1){
            if (matrix[row][col] == k){
                return true;

            }//如果当前值大于目标值，则向右移动
            else if(matrix[row][col] > k){
                col --;
            }else{ //否则，向下移动
                row ++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        for (int i = 0; i < matrix.length-1;i++){
            for (int j = 0; j< matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        int K = 233;
        System.out.println(findNum(matrix, K));
    }
}
