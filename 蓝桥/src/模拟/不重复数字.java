package 模拟;

import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/10/10 21:09
 **/

public class 不重复数字 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(check(i)) {
                count ++;
            }
        }
        System.out.println(count);
    }

    private static boolean check(int n) {
        // TODO 自动生成的方法存根
        if (n < 10) {
            return true;
        }
        int[] a = new int[10];
        while (n > 0) {
			a[n%10] ++;
            n /=10;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 1) {
                return   false;
            }
        }
        return true;
    }

}
