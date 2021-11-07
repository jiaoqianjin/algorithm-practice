package sort;

import util.Util;

/**
 * Description：选择排序
 * 原理：
 * 从第二个元素开始，后一个元素和前一个元素对比，后面的小，则交换
 * 对每一对相邻元素重复以上工作，一轮之后，最小的在第一个
 * 除去第一个，重复以上步骤
 * 对越来越少的元素重复以上步骤，直至无元素比较
 * 时间复杂度：
 * 平均时间复杂度：O(n^2)
 *
 * 稳定性：
 * 不稳定
 * [3,3,6,2] ->[2,3,6,3]
 *
 * @author jiaoqianjin
 * Date: 2021/7/3 10:24
 **/

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 25, 8, 4, 3, 65, 1, 2, 48, 9, 5, 40};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            Util.swap(arr, i, minIndex);
        }
        Util.printArray(arr);
    }
}
