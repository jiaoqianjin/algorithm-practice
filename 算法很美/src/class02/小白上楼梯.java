package class02;

import java.util.Scanner;

/**
 * @Auther:焦前进
 * @Data:2020/3/16
 * @Description:
 * 小白正在上楼梯，楼梯有n阶楼梯
 * 小白可以一次上 1阶，2阶，3阶
 * 实现一个方法，计算小白有多少中走完楼梯的方式
 *
 */
public class 小白上楼梯 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        while (true){
            int n = sc.nextInt();
            int res = f(n);
            System.out.println(res);
        }
    }
    public static int f(int n){
        if (n==0) return 1;
        if (n==1) return 1;
        if (n==2) return 2;
        return f(n-1)+f(n-2)+f(n-3);
    }
}
