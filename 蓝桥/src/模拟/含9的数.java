package 模拟;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/10/10 21:49
 **/

public class 含9的数 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 2019; i++) {
            if (check(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean check(int n) {
        while (n > 0) {
            if (n % 10 == 9) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
}
