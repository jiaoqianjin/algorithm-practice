package class02;

import java.sql.Timestamp;
import java.util.Scanner;

/**
 * @author dell
 * @Auther:焦前进
 * @Data:2020/3/16
 * @Description:
 * 小白正在上楼梯，楼梯有n阶楼梯
 * 小白可以一次上 1阶，2阶，3阶
 * 实现一个方法，计算小白有多少中走完楼梯的方式
 *
 */
public class 小白上楼梯 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (true){
            int n = sc.nextInt();
            int res = f(n);
            System.out.println(res);
            System.out.println(f1(n));


        }
    }
    public static int f(int n){
        if (n==0) {
            return 1;
        }
        if (n==1) {
            return 1;
        }
        if (n==2) {
            return 2;
        }
        return f(n-1)+f(n-2)+f(n-3);
    }
    public static int f1(int n) {
        if (n < 0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        if (n==2) {
            return 2;
        }
        if (n==3) {
            return 4;
        }
//        int x1 = 1;
//        int x2 = 2;
//        int x3 = 4;
//        for (int i = 4; i <= n; i++) {
//            int x_1 = x1;
//            x1 = x2;
//            x2 = x3;
//            x3 = x1 + x2 + x_1;
//        }
//        return x3;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i < arr.length; i++) {
           arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        return arr[n];
    }
}
