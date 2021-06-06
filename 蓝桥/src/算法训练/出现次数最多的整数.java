package 算法训练;

import java.util.Scanner;

/**
 * Description：
 *编写一个程序，读入一组整数，这组整数是按照从小到大的顺序排列的，它们的个数N也是由用户输入的，最多不会超过20。然后程序将对这个数组进行统计，把出现次数最多的那个数组元素值打印出来。如果有两个元素值出现的次数相同，即并列第一，那么只打印比较小的那个值。
 * 　　输入格式：第一行是一个整数N，N £ 20；接下来有N行，每一行表示一个整数，并且按照从小到大的顺序排列。
 * 　　输出格式：输出只有一行，即出现次数最多的那个元素值。
 * @author jiaoqianjin
 * Date: 2020/5/27 16:37
 **/

public class 出现次数最多的整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        if (length < 1 || length > 20 ) {
            return;
        }
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        int[] helper = new int[arr[length-1] - arr[0] + 1]; //辅助数组，该数组的指针为arr的值，值重复，则该位置指针加1
        for (int i = 0; i < length; i++) {
            helper[arr[i] - arr[0]] +=1; // arr[i] - arr[0] 解决负数的情况。helper数组的指针代表 整数。指针位置的数为出现的次数
        }
        int max = 0;
        for (int i = 0; i < helper.length; i++) {
            if(helper[i] == helper[max]) {
                max = max;
            } else if (helper[i] > helper[max]) {
                max = i;
            }
        }
        System.out.println(max + arr[0]);
    }
}
