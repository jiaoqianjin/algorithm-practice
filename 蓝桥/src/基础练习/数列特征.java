package 基础练习;

import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/4/16 16:28
 **/

public class 数列特征 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int min = Integer.MIN_VALUE,sum = 0, max = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i ++){
            sum += arr[i];
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(sum);

    }

}
