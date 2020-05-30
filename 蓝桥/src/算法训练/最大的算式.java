package 算法训练;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Description：
 *　题目很简单，给出N个数字，不改变它们的相对位置，在中间加入K个乘号和N-K-1个加号，（括号随便加）使最终结果尽量大。因为乘号和加号一共就是N-1个了，所以恰好每两个相邻数字之间都有一个符号。例如：
 * 　　N=5，K=2，5个数字分别为1、2、3、4、5，可以加成：
 * 　　1*2*(3+4+5)=24
 * 　　1*(2+3)*(4+5)=45
 * 　　(1*2+3)*(4+5)=45
 * @author jiaoqianjin
 * Date: 2020/5/29 15:40
 **/

public class 最大的算式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length - K; i++) {
            sum += arr[i];
        }
        int mul = 1;
        for (int i = arr.length - K; i < arr.length; i++) {
            mul *= arr[i];
        }
        int res = sum * mul;
        System.out.println(res);
    }
}
