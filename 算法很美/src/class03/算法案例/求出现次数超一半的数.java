package class03.算法案例;

import util.Util;

import java.util.Arrays;

/**
 * @Auther:焦前进
 * @Data:2020/3/20
 * @Description:
 * 超过一半的数字
 * 数组中有一个数字出现的次数超过了数组长度得一半，找出这个数字
 */
public class 求出现次数超一半的数 {
    /**
     * 方法一：直接排序，位于中间的数就是所求值
     * @param arr
     */
    public static void solve1 (int[] arr){
        Arrays.sort(arr);
        System.out.println(arr[arr.length/2]);
    }

    /**
     * 方法二：查找第K个元素，时间复杂度位O（n）
     * @param arr
     */
    public static void solve2(int[] arr){
        System.out.println(第K个元素.selectK(arr,0,arr.length-1,arr.length/2));
    }
    /**
     * 方法三： 使用hash
     */
    /**
     * 方法四：不同的数进行消除
     * @param arr
     */
    public static void solve4(int[] arr){
        //候选数
        int candidate = arr[0];
        //出现的次数
        int nTimes = 1;
        //扫描数组
        for(int i = 1;i < arr.length; i++){
            //两两消减为0，把现在的值作为后选值
            if (nTimes == 0){
                candidate = arr[i];
                nTimes = 1;
                continue;
            }
            //遇到候选值相同的，次数加1
            if(arr[i] == candidate){
                nTimes ++;
            }else {
                nTimes --;
            }
        }
        System.out.println(candidate);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,4,4,4,4,5,5,5,5,5,5,5,5};
        Util.printArray(arr);
       solve1(arr);
       solve2(arr);
       solve4(arr);
    }
}
