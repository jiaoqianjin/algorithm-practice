package 算法训练;

import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/5/30 15:50
 **/

public class RP大冒险 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N > 10) {
            N %= 10;
        }
        System.out.println((int)(Math.pow(N,Math.random())));
    }
}
