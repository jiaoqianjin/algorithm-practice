package interview.fanmi;

import java.util.Scanner;

/**
 * Description：计算是否是素数
 *
 * @author jiaoqianjin
 * Date: 2021/12/25 13:49
 **/

public class A_JudgePrime {

    /**
     * 功能描述: 除了1和本身外，不能被其他数整除
     */
    public static void isPrime(int n) {
        int m = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                m++;
        }
        if (m == 0)
            System.out.println(n + "是素数");
        else
            System.out.println(n + "不是素数");
    }

    public static void main(String[] args) {
        System.out.print("请输入一个数字：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        isPrime(n);
    }
}
