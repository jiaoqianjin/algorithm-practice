package com.ten;

import com.util.Util;

/**
 * Description： 冒泡排序
 * 比较相邻的元素，如果第一个比第二个大，就交换它们两；
 * 对每个对相邻元素做同样的工作，从开始第一对到最后一对，这样在最后的元素应该会是最大的数；
 * 针对所有的元素重复以上的步骤，除了最后一个；
 * 重复以上 1- 3，直到排序完成
 *
 * @author jiaoqianjin
 * Date: 2020/9/24 20:06
 **/

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Util.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = Util.getRandomArr(10, 2, 50);
        Util.printArray(test);
        bubbleSort(test);
        Util.printArray(test);
    }
}
