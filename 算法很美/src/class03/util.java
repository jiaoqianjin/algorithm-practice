package class03;

import class03.树.小根堆化;

import java.util.Arrays;

/**
 * @Auther:焦前进
 * @Data:2020/3/19
 * @Description:
 */
public class util {
    /**
     * 交换元素
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void printArray(int[] arr) {
//        if (arr == null) {
//            return;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 随机产生数组
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 求数组中的最大值
     * @param arr
     * @return
     */
    public static int maxOf(int[] arr){
//        小根堆化.minHeapSort(arr);
//        return arr[0];
        int max = 0;
        for(int i = 1 ; i < arr.length;i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return arr[max];
    }

    public static int minOf(int[] arr) {
        int min = 0;
        for(int i = 1 ; i < arr.length;i++){
            if(arr[i] < arr[min]){
                min = i;
            }
        }
        return arr[min];
    }
}
