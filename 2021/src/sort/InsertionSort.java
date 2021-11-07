package sort;

import util.Util;

/**
 * Description：插入排序
 * 原理：
 * 将第一个数当做有序序列，后面的作为无序序列
 * 要排序的值向有序序列插
 * 与有序序列最后一个值对比，如果当前值小，交换
 * 再与前一个值比较，小，交换，大，成功
 * 重复以上步骤
 * 分析：
 * 时间复杂度
 * 最坏情况O(n^2)
 * 最好情况O(n)
 *
 * 稳定性
 * 稳定
 *
 * @author jiaoqianjin
 * Date: 2021/7/3 10:57
 **/

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 9, 6, 4, 1};

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    Util.swap(arr, j, j + 1);
                }
            }
            Util.printArray(arr);
        }
    }
}
