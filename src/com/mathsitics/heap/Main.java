package com.mathsitics.heap;

import java.util.Random;

/**
 * @Auther:焦前进
 * @Data:2020/2/1
 * @Description:
 */
public class Main {
    private static double testHeap(Integer[] testData ,boolean idHeapify){
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (idHeapify){
            maxHeap = new MaxHeap<>(testData);
        }else{
            maxHeap = new MaxHeap<>();
            for (int num : testData){
                maxHeap.add(num);
            }
        }

        int[] arr = new int[testData.length];
        for (int i = 0 ; i < testData.length ;i ++){
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1 ; i < testData.length ; i++){
            if (arr[i - 1] < arr[i]){
                throw new  IllegalArgumentException("error");
            }
        }
        System.out.println("测试成功");
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static void main(String[] args) {
//        int n = 100000;
//        MaxHeap<Integer> maxHeap = new MaxHeap<>();
//        Random random = new Random();
//        for (int i = 0 ; i < n ; i ++){
//            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
//        }
//        int[] arr = new int[n];
//        for (int i = 0 ; i < n ;i ++){
//            arr[i] = maxHeap.extractMax();
//        }
//        for (int i = 1 ; i < n ; i++){
//            if (arr[i - 1] < arr[i]){
//                throw new  IllegalArgumentException("error");
//            }
//        }
//        System.out.println("测试成功");
        int n = 100000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0 ; i < n ; i ++){
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData,false);
        System.out.println("time1:"+time1);
        double time2 = testHeap(testData,true);
        System.out.println("time2:"+time2);

    }
}
