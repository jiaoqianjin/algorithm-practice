package 基础练习;

import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/4/20 17:34
 **/

public class 质因分解_明灿 {
        public static void main(String[] args) {
            Scanner sc =new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            for(;a<=b;a++) {
                System.out.print(a+"=");
                factor(a);
            }
        }
        static void factor(int number){
            int t=isPrime(number);
            if(t==0) System.out.println(number);
            else {
                System.out.print(t+"*");
                factor(number/t);
            }
        }

        static int isPrime(int number){
            int res=0;
            for(int i=2;i<number;i++)
            {
                if(number%i==0)
                {
                    return i;
                }
            }
            return res;
        }
    }
