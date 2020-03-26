package class02;

import sun.nio.ch.Util;

import java.util.Arrays;

/**
 * @Auther:焦前进
 * @Data:2020/3/11
 * @Description: 希尔排序
 */
public class 希尔排序 {
    private static void shellSort(int[] arr){
        //不断缩小增量


        for (int interval = arr.length/2;interval > 0;interval = interval/2){
            for (int i = interval ; i < arr.length; i++){
                int target = arr[i];
                int j = i - interval;
                while (j > -1 && target < arr[j]){
                    arr[j+interval] = arr[j];
                    j = interval;
                }
                arr[j + interval] = target;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,9,8,6,4,3};
        shellSort(arr);
    }
}
