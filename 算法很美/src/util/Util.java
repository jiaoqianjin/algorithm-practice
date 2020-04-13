package util;

import class03.树.小根堆化;

import java.util.Arrays;

/**
 * @Auther:焦前进
 * @Data:2020/3/19
 * @Description:
 */
public class Util {
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
     * 获取指定范围指定个数的随机数组成的数组
     *
     * @param length
     * @param min
     * @param max
     * @return
     */
    public static int[] getRandomArr(int length, int min, int max) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * (max + 1 - min) + min);
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

    /**
     * 打印二维数组
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        if(matrix == null){
            return;
        }
        for(int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[0].length; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    /**
     * 打印二维数组
     * @param matrix
     */
    public static void printMatrix1(long[][] matrix) {
        if(matrix == null){
            return;
        }
        for(int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[0].length; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    /**
     * 以最快速度求a的n次方
     * 巧算
     * m=1010
     */
    public static long ex2(long n, long m) {
        if (n == 0) return 1;
        long pingFangShu = n; //n 的 1 次方
        long result = 1;
        while (m != 0) {
            //遇1累乘现在的幂
            if ((m & 1) == 1)
                result *= pingFangShu;
            //每移位一次，幂累乘方一次
            pingFangShu = pingFangShu * pingFangShu;
            //右移一位
            m >>= 1;
        }
        return result;
    }
}
