package com.ten;

import com.util.Util;

/**
 * Description： 选择排序
 * 从第一个元素开始，该元素可以认为已经被排序
 * 未排序的值向有序的序列中插值
 * 未排序的值与排好序的最后一个值比较，如果当前值小，交换
 * 重复步骤3
 * 将新元素插入到该位置后
 * 重复步骤2-5
 *
 * @author jiaoqianjin
 * Date: 2020/9/24 21:11
 **/

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--) {
                Util.swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] test = Util.getRandomArr(10, 2, 50);
        Util.printArray(test);
        insertionSort(test);
        Util.printArray(test);
    }
}
