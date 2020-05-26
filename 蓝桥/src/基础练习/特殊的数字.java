package 基础练习;

/**
 * Description：
 * 153是一个非常特殊的数，
 * 它等于它的每位数字的立方和，
 * 即153=1*1*1+5*5*5+3*3*3。
 * 编程求所有满足这种条件的三位十进制数。
 *
 * @author jiaoqianjin
 * Date: 2020/4/18 15:47
 **/

public class 特殊的数字 {
    public static void main(String[] args) {
        for(int i = 100; i < 1000; i++) {
            int a = i /100,b = i % 100 /10, c = i % 10;
                if(i == a*a*a +b*b*b+c*c*c) {
                    System.out.println(i);
                }
            }
        }
    }
