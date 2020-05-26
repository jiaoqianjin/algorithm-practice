package 基础练习;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/4/18 17:09
 **/

public class 数列排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
