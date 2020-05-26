package 基础练习;

import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/4/18 17:27
 **/

public class 时间转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = n / 3600 ,b = n / 60 % 60,c = n % 60;
        System.out.println(a+":"+b+":"+c);
    }
}
