package class02;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * @Auther:焦前进
 * @Data:2020/3/16
 * @Description:
 * （1,9,2,5,7,3,4,6,8,0）中最长的递增子序列为（3,4,6,8）
 */
public class 最长连续递增子序列 {
    static int maxLengthAdd(int[] arr){
        if(arr.length == 0)
            return 0;
        int max =  0;
        int num = 1;
        for (int i = 0;i < arr.length - 1;i++) {
            if(arr[i] < arr[i + 1]){
                num ++;
            }else {
                if (num > max){
                    max = num;
                }
                num = 1;
            }
        }
        return Math.max(num,max);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(maxLengthAdd(arr));
    }
//    public static int longincreaseSonList(int[] arr) {
//        int[] dp=new int[arr.length];
//        dp[0]=1;
//        //循环求dp中剩余的值
//        for (int i = 1; i <arr.length ; i++) {
//            //计算在arr[i]之前的所有比arr[i]小的数且子序列值最大的也就是
//            // 关系状态方程：dp[i]=max{dp[j]+1(0<=j<i,arr[j]<arr[i])}
//            int max=0;
//            for (int j = i; j >=0 ; j--) {
//                if (arr[j]<arr[i]&&dp[j]>max){
//                    max=dp[j];
//                }
//            }
//            dp[i]=max+1;
//        }
//        Arrays.sort(dp);
//        return dp[dp.length-1];
//    }
//
//    public static void main(String[] args) {
//        int[] arr={1,2,3,4,5};
//        System.out.println(longincreaseSonList(arr));
//    }

}
