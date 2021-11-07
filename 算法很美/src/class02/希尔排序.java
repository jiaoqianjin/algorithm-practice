package class02;

import sun.nio.ch.Util;

import java.util.Arrays;

/**
 * @Auther:焦前进
 * @Data:2020/3/11
 * @Description: 希尔排序
 */
public class 希尔排序 {
    private static void shellSort(int[] arr) {
        //不断缩小增量

//        for (int interval = arr.length / 2; interval > 0; interval = interval / 2) {
//            for (int i = interval; i < arr.length; i++) {
//                int target = arr[i];
//                int j = i - interval;
//                while (j > -1 && target < arr[j]) {
//                    arr[j + interval] = arr[j];
//                    j -= interval;
//                }
//                arr[j + interval] = target;
//            }
//        }


        int min;
        int minValue;
        for (int grap = arr.length / 2; grap > 0; grap /= 2) {
            for (int i = grap; i < arr.length; i++) {
                min = i;
                minValue = arr[i];
                while (min >= grap && minValue < arr[min - grap]) {
                    arr[min] = arr[min - grap];
                    min -= grap;
                }
                arr[min] = minValue;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        shellSort(arr);
    }
}
