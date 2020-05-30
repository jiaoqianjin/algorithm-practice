package 算法训练;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Scanner;

/**
 * Description：
 *已知一个正整数N，问从1~N中任选出三个数，他们的最小公倍数最大可以为多少。
 * @author jiaoqianjin
 * Date: 2020/5/27 15:04
 **/

public class 最大最小公倍数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        if(N < 2) {
            System.out.println(N);
        }
        if (N % 2 != 0) {  // 如果 N 为奇数，最大最小公倍数为 N(N-1)(N-2)
            System.out.println(N*(N-1)*(N-2));
        } else {  // 如果 N 为偶数 ，分为两种情况
            if(N % 3 != 0) {  // 如果 N 不能被 3 整除，最大最小公倍数N(N-1)(N-3)
                System.out.println(N*(N-1)*(N-3));
            }else { //  如果能被 3 整除，则 (N-3)也能被 3 整除，所以最大最下公倍数应该为 (N-1)(N-2)(N-3)
                System.out.println((N - 1) * (N - 2) * (N - 3));
            }
        }
    }
}
