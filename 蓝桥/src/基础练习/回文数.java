package 基础练习;

import java.util.Arrays;

/**
 * Description：
 *1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。
 * @author jiaoqianjin
 * Date: 2020/4/18 16:13
 **/

public class 回文数 {
    public static void main(String[] args) {
        for (int i= 1; i < 10 ;i++) {
            for (int j= 1; j < 10 ;j++) {
                System.out.println(i*1000+j*100+j*10+i);
            }
        }
    }
}
