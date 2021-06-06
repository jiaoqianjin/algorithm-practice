package 模拟;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/10/10 21:37
 **/

public class 最大质数 {
    public static void main(String[] args) {
        for (int i = 1; i < 10000; i++) {                    //从1开始到10000开始寻找质数
            for (int j = 2; j < i; j++) {                    //除了1和本身之外能整除
                int a = i % j;                            //a为每次除后的余数，为0即能被整除，即不为质数
                if (a == 0) {
                    break;
                }
                if (j + 1 == i) {                            //当除数达到 被除数-1 也不能被整数的话，即为质数
                    System.out.println(i);
                }
            }
        }
    }
}
