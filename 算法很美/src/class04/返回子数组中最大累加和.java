package class04;

import util.Util;

import java.util.Arrays;
import java.util.Date;

/**
 * @Author 焦前进
 * @Date: 2020/4/1 16:07
 * @Description: 子数组最大累加和
 * 给定一个数组arr,返回子数组的最大累加和
 * 例：arr = [1,-2,3,5,-2,6,-1];所有的子数组中【3,5，-2,6】可以累加出最大的和12，所以返回12
 **/
public class 返回子数组中最大累加和 {
    /**
     * 方法一：暴力破解
     * @param arr
     */
    public static void findByForce(int[] arr){
        int maxSum = arr[0]; //记录最大值
        for (int i = 0; i < arr.length; i++){
            int sum = arr[i];
            int maxOf = sum; //记录每一个数作为头部时，产生的最大值
            for(int j = i + 1; j < arr.length; j++){
                sum += arr[j]; // 累加后续元素
                if(sum > maxOf){
                    maxOf = sum; //累计几个后续元素大，这个几个数的和就作为 本轮最大值
                }
            }
            if(maxOf > maxSum){
                maxSum = maxOf; //如果本轮最大值大于最大值，则最大值更改为本轮最大值
            }
        }
        System.out.println(maxSum);
    }

    /**
     * 递推法
     * @param arr
     */
    public static int findByDp(int[] arr){
        int sum = arr[0];
        int max = sum; //记录子数组的最大值
        int left = 0,right = 0; //记录最大累加和子数组 左下标和右下标
        for(int i = 1 ; i < arr.length; i++){
            if(sum > 0){ //左数组的和大于0，继续向后累加
                sum += arr[i];
            }else {
                sum = arr[i];
                left = i; //丢弃前面部分时，记录当前位置
            }
            if(sum > max){ //累加和大于最大值，最大值更新
                max = sum;
                right = i;
            }
        }
//        System.out.println("left="+left+" "+"right="+right);
        return max;
    }
    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(1000,-100,100);
        System.out.println("数组"+ Arrays.toString(arr));
        long now = new Date().getTime();
        findByForce(arr);
        long next1 = new Date().getTime();
        System.out.println("暴力法，时间消耗："+(next1 - now));
        long now1 = new Date().getTime();
        System.out.println(findByDp(arr));
        long next2 = new Date().getTime();
        System.out.println("递推法，时间消耗："+(next2 - now1));
    }
}
