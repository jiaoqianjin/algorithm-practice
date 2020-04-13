package class04;

import javax.sound.midi.Soundbank;

/**
 * @Author 焦前进
 * @Date: 2020/3/31 14:59
 * @Description:
 *  顺时针打印二维数组
 *  输入
 *  1 	2 	3 	4
 *  5 	6 	7 	8
 *  9 	10 	11 	12
 *  13	14	15	16
 *  输出
 *  1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 **/
public class 顺时针打印二维数组 {
    public static void print(int[][] matrix){
        int leftUpRow = 0,leftUpCol = 0,rightDownRow = matrix.length - 1,rightDownCol = matrix[0].length - 1;
        while (leftUpRow <= rightDownRow && leftUpCol <= rightDownCol){
            //初始化指针
            int r = leftUpRow,c = leftUpCol;
            //打印上边第一条边
            while (c <= rightDownCol){
                System.out.print(matrix[r][c++] + " ");
            }
            //恢复
            c = rightDownCol;
            r++;
            //打印最右边的边
            while (r <= rightDownRow){
                System.out.print(matrix[r++][c] + " ");
            }
            //恢复
            r = rightDownRow;
            c--;
            //打印下边的边
            while (c >= leftUpCol){
                System.out.print(matrix[r][c--] + " ");
            }
            //恢复
            c = leftUpCol;
            r--;
            //打印最左边的边
            while (r > leftUpRow){
                System.out.print(matrix[r--][c] + " ");
            }
            leftUpRow++;leftUpCol++;rightDownRow--;rightDownCol--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {5, 6, 7, 8, 9},
                {9, 10, 11, 12, 13},
                {13, 14, 15, 16, 17},
                {18, 19, 20, 21, 22},
        };
        print(matrix);
    }
}
