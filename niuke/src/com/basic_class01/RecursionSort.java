package com.basic_class01;


/**
 * @Auther:焦前进
 * @Data:2020/2/10
 * @Description: 递归求数组中最大值
 */
public class RecursionSort {
    public static int getMax(int[] arr,int L,int R){
        if (L == R){
            return arr[L];
        }
        int mid = (L + R) / 2;
        int maxLeft = getMax(arr,L,mid);
        int maxRight = getMax(arr,mid + 1,R);
        return Math.max(maxLeft,maxRight);
    }

    public static void main(String[] args) {
        int[] arr = {4,5,2,1};
        System.out.println(getMax(arr,0,arr.length-1));
    }
}
