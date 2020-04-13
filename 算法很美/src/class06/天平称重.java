package class06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author 焦前进
 * @Date: 2020/4/7 15:39
 * @Description:
 * 用天平称重时，我们希望用尽可能少的砝码组合称出尽可能多的重量。
 * 如果只有5个砝码，重量分别是1，3，9，27，81
 * 则它们可以组合称出1到121之间任意整数重量（砝码允许放在左右两个盘中）。
 *
 * 本题目要求编程实现：对用户给定的重量，给出砝码组合方案。
 * 例如：
 * 用户输入：
 * 5
 * 程序输出：
 * 9-3-1
 * 用户输入：
 * 19
 * 程序输出：
 * 27-9+1
 *
 * 要求程序输出的组合总是大数在前小数在后。
 * 可以假设用户的输入的数字符合范围1~121。
 **/
public class 天平称重 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 转成3进制
        final String x = Integer.toString(N,3);
        // 反转后转成字符数组
        char[] arr = new StringBuilder(x).reverse().toString().toCharArray();
        //容器放处理之后的0 -1 1
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == '2') {
                list.add(0,-1);
                if(i == arr.length - 1) {
                    list.add(0,1);
                } else {
                    ++arr[i + 1]; // 否则，对下一个数字加1
                }
            } else if (arr[i] == '3') {
                list.add(0, 0);//插入0
                //更高位进1
                if (i == arr.length - 1) {
                    list.add(0, 1);
                } else {
                    ++arr[i + 1];
                }
            } else {
                list.add(0, arr[i] - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) sb.append("+").append((int) Math.pow(3, list.size() - i - 1));
            if (list.get(i) == -1) sb.append("-").append((int) Math.pow(3, list.size() - i - 1));
        }
        System.out.println(sb.substring(1));
    }
}
