package com.mathsitics.xaXianBei;

/**
 * 定义a=1; b=2;
 * 希望你进行某种运算后输出
 * a=2; b=1;
 * 此题有三种解法。
 */
public class Change {
    private int a;
    private int b;

    Change(){
        a = 1;
        b = 2;
        change1(a,b);
    }
    public void change1(int a,int b){
        int c = 0;
        c = b;
        b = a;
        a = c;
        System.out.println(a);
        System.out.println(b);
    }
    public static void main(String[] args) {
        new Change();
    }
}
