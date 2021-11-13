package com.ten;

import com.util.Util;

/**
 * Description： 选择排序
 * 从第一个元素开始，后一个元素和当前元素进行对比，分出那个小，记录下位置
 * 之后每一次对比都和上一次对比出来的最小值对比，记录本轮最小值的位置，和第一个元素交换
 * 去掉第一个元素，重复上述步骤，每次得到对比的最小值
 *
 * 分析：最优： n²，最差 n²，平均 n²
 *
 * @author jiaoqianjin
 * Date: 2020/9/24 20:34
 **/

public class SelectiontSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            Util.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] test = Util.getRandomArr(10, 5 , 50);
        Util.printArray(test);
        selectionSort(test);
        Util.printArray(test);
    }
}
