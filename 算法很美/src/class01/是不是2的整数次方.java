package class01;

import java.util.Scanner;

/**
 * @Auther:焦前进
 * @Data:2020/3/4
 * @Description:
 * 用一条语句判断一个整数是不是2的整数次方
 * 分析，2的整数次方 就是2进制中只有一个1
 */
public class 是不是2的整数次方 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(N +"的二进制位"+Integer.toString(N,2));
        for (int i = 0; i < 32;i ++){
            if (((N-1)&N) == 0){
                System.out.println(N + "是2的整数次方");
                return;
            }else {
                System.out.println(N +"不是2的整数次方");
                return;
            }
        }
    }
}
