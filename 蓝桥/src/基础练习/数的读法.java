package 基础练习;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/4/22 16:19
 **/

public class 数的读法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        readToChinese(m);
    }
    public static void readToChinese(int n){
        if(n < 10000){
            thousandSay(n);
            System.out.println();
        }else if(n < 100000000){
            int n1 = n / 10000;
            int n2 = n % 10000;
            if(n2 == 0){
                thousandSay(n1);
                System.out.print("wan");
                System.out.println();
            }else {
                thousandSay(n1);
                System.out.print("wan ");
                thousandSay(n2);
                System.out.println();
            }
        }else if(n < 2000000000){
            int n1 = n / 100000000;
            int n2 = (n/10000) % 10000;
            int n3 = n % 10000;
            thousandSay(n1);
            System.out.print("yi(亿) ");
            thousandSay(n2);
            System.out.print("wan ");
            thousandSay(n3);
            System.out.println();
        }else if(n == 2000000000){
            System.out.println("er yi()亿");
            System.out.println();
        }else {
            System.out.println("输入错误，正确范围是（0-20 0000 0000）");
        }
    }

    public static void thousandSay(int n){
        String[] arr = new String[]{"ling ","yi ","er ","san ","si ","wu ","liu ","qi ","ba ","jiu "};
        String shi = "shi ";
        String bai = "bai ";
        String qian = "qian ";
        int num = n;
        if(n < 10){
            System.out.print(arr[n]);
        }else if(n < 100){
            int a = n / 10;
            int b = n % 10;
            if(b == 0){
                System.out.print(arr[a]+shi);
            }else if(a == 1){
                System.out.print(shi+arr[b]);
            } else {
                System.out.print(arr[a]+shi+arr[b]);
            }
        }
        else if(n < 1000){
            int a = n / 100;
            int b = (n / 10) % 10;
            int c = n % 10;
            if(b == 0 && c == 0){
                System.out.print(arr[a]+bai);
            }else if(b == 0 & c != 0){
                System.out.print(arr[a]+bai+arr[0]+arr[c]);
            }else if(b != 0 && c == 0){
                System.out.print(arr[a]+bai+arr[b]+shi);
            }else {
                System.out.print(arr[a]+bai+arr[b]+shi+arr[c]);
            }
        }else if(n < 10000){
            int a = n / 1000; //表示千位
            int b = (n / 100) % 10; //表示百位
            int c = (n / 10) % 10; //表示十位
            int d = n % 10; //表示个位
            if(b == c && c == d && d == 0){
                System.out.print(arr[a]+qian);
            }else if (b == 0 && c != 0 & d != 0){
                System.out.print(arr[a]+qian+arr[0]+arr[c]+shi+arr[d]);
            }else if(b == 0 && c == 0 && d != 0){
                System.out.print(arr[a]+qian+arr[0]+arr[d]);
            }else if (b == 0 && c != 0 && d == 0){
                System.out.print(arr[a]+qian+arr[0]+arr[c]+shi);
            }else if(c == 0 && d == 0){
                System.out.print(arr[a]+qian+arr[b]+bai);
            }else if (c == 0 && d != 0){
                System.out.print(arr[a]+qian+arr[b]+bai+arr[0]+arr[d]);
            }else if(d == 0){
                System.out.print(arr[a]+qian+arr[b]+bai+arr[c]+shi);
            }else {
                System.out.print(arr[a]+qian+arr[b]+bai+arr[c]+shi+arr[d]);
            }
        }
    }
//    private static void thousandSay(int m) {
//        String[] arr = new String[]{"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
//        String shi = new String("shi");
//        String bai = new String("bai");
//        String qian = new String("qian");
//        if(m < 10) {
//            System.out.println(arr[m]);
//        } else if (m < 100) {
//            int a = m / 10;
//            int b = m % 10;
//            if(b == 0) {
//                System.out.println(arr[a] + shi);
//            } else if (a == 1) {
//                System.out.println(shi + arr[b]);
//            } else {
//
//            }
//        }
//
//    }
}
