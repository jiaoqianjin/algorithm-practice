package class07;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/10/11 14:39
 **/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class 合法括号_yue {

    /**
     * 问题描述
     * 　　由1对括号，可以组成一种合法括号序列：()。
     * 　　由2对括号，可以组成两种合法括号序列：()()、(())。
     * 　　由4对括号组成的合法括号序列一共有多少种？
     * 答案提交
     * 　　这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ans = new ArrayList<String>();
        ArrayList<String> old = new ArrayList<String>();
        HashSet<String> fin = new HashSet<String>();
        ans.add("()");

        for (int i = 1; i < 4; i++) {
            for (String t : ans) {
                for (int j = 0; j < t.length(); j++) {
                    old.add(t.substring(0, j) + "()" + t.substring(j));
                }
            }
            ans.clear();
            for (String t : old) {
                ans.add(t);
            }
            old.clear();
        }
        for (String t : ans) {
            fin.add(t);
        }
        System.out.println(fin.size());
        for (String t : fin) {
            System.out.println(t);
        }
    }

}

