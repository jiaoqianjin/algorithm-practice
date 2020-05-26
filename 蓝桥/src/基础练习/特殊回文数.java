package 基础练习;

import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/4/18 16:34
 **/

public class 特殊回文数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i= 1; i < 10 ;i++) {
            for (int j = 0; j < 10; j++) {
                for (int q = 0; q < 10; q++) {
                    if (i * 2 + j * 2 + q == n) {
                        int res = i * 10000 + j * 1000 + q * 100 + j * 10 + i;
                        System.out.println(res);
                    }
                }
            }
        }
        for (int i= 1; i < 10 ;i++) {
            for (int j= 0; j < 10 ;j++) {
                for(int q = 0; q < 10; q++) {
                    if(i*2+j*2+q*2==n){
                        int res1 = i * 100000 + j * 10000 + q * 1000 + q*100 + j*10+i;
                        System.out.println(res1);
                    }
                }
            }
        }
//        for(int i = 10000; i <= 999999; i++) {
//            if (i < 100000) {
//                int g = i / 1 % 10;			//个位数字
//                int s = i / 10 % 10;		//十位数字
//                int b = i / 100 % 10;		//百位数字
//                int q = i / 1000 % 10;		//千位数字
//                int w = i / 10000 % 10;		//万位数字
//                if (g == w && s == q && g+s+b+q+w == n) {
//                    System.out.println(i);
//                }
//            }else {
//                int g = i / 1 % 10;			//个位数字
//                int s = i / 10 % 10;		//十位数字
//                int b = i / 100 % 10;		//百位数字
//                int q = i / 1000 % 10;		//千位数字
//                int w = i / 10000 % 10;		//万位数字
//                int sw = i / 100000 % 10;		//十万位数字
//                if (g == sw && s == w && b == q && g+s+b+q+w+sw == n) {
//                    System.out.println(i);
//                }
//            }
//        }
    }
}
