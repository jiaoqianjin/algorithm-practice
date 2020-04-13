package class04;

import util.Util;

/**
 * @Author 焦前进
 * @Date: 2020/3/31 15:28
 * @Description: 0 所在的行列清零
 * 如果矩阵中某个元素为0，则将其所在行和列清零
 **/
public class 将0所在行列清零 {
    public static void solve(int[][] matrix){
        int M = matrix.length; //二维数组行的长度
        int N = matrix[0].length; //二维数组列的长度
        int[] rowRecord = new int[M]; //记录那些行出现了0
        int[] colRecord = new int[N]; //记录哪些列出现了0
        //遍历二维数组，将0出现的行列记录下来
        for(int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if(matrix[i][j] == 0){
                    rowRecord[i] = 1;
                    colRecord[j] = 1;
                }
            }
        }
        //遍历记录数组，将0所在行列清零
        for(int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if(rowRecord[i] == 1 || colRecord[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 100},
                {5, 6, 7, 0, 101},
                {9, 0, 11, 12, 102},
                {13, 14, 15, 16, 103},
                {104, 105, 106, 107, 103},
        };
        solve(matrix);
        Util.printMatrix(matrix);
    }
}
