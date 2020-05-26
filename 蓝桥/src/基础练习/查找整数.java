package 基础练习;

import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/4/16 16:53
 **/

public class 查找整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int a = sc.nextInt();
        sc.close();
        boolean flog = false;
        for(int i = 0; i < arr.length; i++){
            if(a == arr[i]){
                System.out.println(i+1);
                flog = true;
                return;
            }
        }
        if(!flog){
            System.out.println(-1);
        }
    }
}
