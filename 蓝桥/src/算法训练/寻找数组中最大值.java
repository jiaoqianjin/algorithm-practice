package 算法训练;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/5/27 16:12
 **/

public class 寻找数组中最大值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        System.out.println(arr[max] + " " + max);
    }
}
