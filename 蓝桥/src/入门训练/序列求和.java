package 入门训练;

import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/4/15 16:16
 **/

public class 序列求和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        System.out.println(n*(n+1)/2);
    }
}
