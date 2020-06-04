package 算法训练;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Description：
 *Torry从小喜爱数学。一天，老师告诉他，像2、3、5、7……这样的数叫做质数。
 * Torry突然想到一个问题，前10、100、1000、10000……个质数的乘积是多少呢？他把这个问题告诉老师。
 * 老师愣住了，一时回答不出来。于是Torry求助于会编程的你，请你算出前n个质数的乘积。
 * 不过，考虑到你才接触编程不久，Torry只要你算出这个数模上50000的值。
 *
 * @author jiaoqianjin
 * Date: 2020/6/4 15:19
 **/

public class Torry的困惑 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        boolean flag = true;
        long num = 1;
        ArrayList<Long> al = new ArrayList<Long>();//定义一个LONG型数组用于存入质数
        for (long i = 2; i <= 100000; i++) {
            for (int j = 2; j < i; j++) {
                if(i%j==0){
                    flag = false;
                    break;
                }else{
                    flag = true;
                }
            }
            if(flag==true){
                al.add(i);//若是质数则添加到数组中
                if(al.size()==n){//当数组长度达到指定要求时返回
                    break;
                }
            }
        }
        for (int i = 0; i <al.size(); i++) {//计算乘积
            num = num*al.get(i)%50000;
        }
        System.out.print(num);
    }
}
