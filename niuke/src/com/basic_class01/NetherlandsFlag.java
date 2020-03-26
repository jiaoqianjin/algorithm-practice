package com.basic_class01;

import static com.basic_class01.BubbleSort.swap;

/**
 * @Auther:焦前进
 * @Data:2020/2/11
 * @Description: 荷兰国旗问题
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的
 * 左边，等于num的数放在数组的中间，大于num的数放在数组的
 * 右边。
 */
public class NetherlandsFlag {
    public static int[] partition(int[] arr,int L,int R,int num){
        int less = L - 1;   //定义比num小的部分的指针
        int more = R + 1;   //定义比num大的部分的指针
        int cur = L;
        while (cur < more){
            //如果值比num小，则less+1 位置的数与cur位置的数交换，同时cur向右移动一位
            if(arr[cur] < num){
                swap(arr,++less,cur++);
            }//如果值比num大，则more-1位置的数与cur位置的数交换，cur不变，继续判断cur位置的数
            else if(arr[cur] > num){
                swap(arr,--more,cur);
            }//如果相等，cur向右移动一位
            else{
                cur++;
            }
        }
        return new int[]{less + 1,more - 1};
    }
    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res.length);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
