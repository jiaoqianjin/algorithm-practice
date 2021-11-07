package offer;

import java.util.Scanner;

/**
 * Description：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序，请完成一个函数，
 * 输入一个二维数组和一个整数，判断数组是否含有该整数。
 *
 * @author jiaoqianjin
 * Date: 2021/9/11 9:27
 **/

public class Four {
    /**
     * 解题思路：
     * 先找到右上角的数字，对比是否等于要找的数字，
     * 如果等于，则结束查找
     * 如果不等于，判断右上角数组与要找的数字
     * 如果右上角数字大，剔除所在列
     * 如果右上角数字小，剔除所在行
     */
    private boolean find(int[][] arr, int target) {
        int rows = 0;
        int columns = arr[0].length - 1;
        while (true) {
            if (arr[rows][columns] == target) {
                return true;
            }
            if (arr[rows][columns] > target) {
                columns--;
                if (columns < 0) {
                    break;
                }
            }
            if (arr[rows][columns] < target) {
                rows++;
                if (rows > arr.length - 1) {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Four four = new Four();
        System.out.println(four.find(arr, 5));
    }
}
