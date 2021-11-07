package sort;

import util.Util;

/**
 * Description： 希尔排序
 *
 * @author jiaoqianjin
 * Date: 2020/9/28 20:14
 **/

public class ShellSort {
    public static void shellSort(int[] arr) {
        if (arr.length > 0) {

        }
        int len = arr.length;
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                // 分组后右侧的值
                int temp = arr[i];
                // 分组后左侧的值
                int index = i - gap;
                while (index >= 0 && arr[index] > temp) {
                    arr[index + gap] = arr[index];
                    index -= gap;
                }
                arr[index + gap] = temp;
            }
            gap /= 2;
        }
    }

    public static void main(String[] args) {
        int[] test = Util.getRandomArr(10, 5, 50);
        Util.printArray(test);
        shellSort(test);
        Util.printArray(test);
    }
}
