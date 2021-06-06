package 算法训练;

import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/6/4 18:31
 **/

public class 动态数组的使用 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int rev = sum / n;
        System.out.println(sum);
        System.out.println(rev);
    }
}
