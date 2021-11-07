package sort;


import util.Util;

/**
 * Description：冒泡排序
 * 原理：
 * 比较相邻两个元素，如果第一个比第二个大，则交换
 * 对每一个相邻元素做同样的工作，从第一队到最后一对，这步做完，最后一位就是最大的数
 * 重复以上步骤，除去最后一个
 * 持续对越来越少的元素重复以上步骤，直至无数字比较
 * <p>
 * 分析：
 * 时间复杂度
 * 最好情况: 正序，无需交换，时间负复杂度为 O(n)
 * 最坏情况：逆序，都需交换，时间复杂度为O(n^2)
 * 稳定性
 * 稳定
 *
 * @author jiaoqianjin
 * Date: 2021/7/3 9:31
 **/

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int l = arr.length;
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Util.swap(arr, j, j + 1);
                }
            }
        }
        Util.printArray(arr);
    }
}
