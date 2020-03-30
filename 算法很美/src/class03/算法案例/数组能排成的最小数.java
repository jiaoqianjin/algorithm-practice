package class03.算法案例;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author 焦前进
 * @Date: 2020/3/30 16:01
 * @Description: 数组能排成的最小数（特殊排序）
 * 输入一个正整数数组，把数组里所有整数拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * 例如输入数组{3,32,321}，则打印出这3个数字能排成的最小数字为：321323
 **/
public class 数组能排成的最小数 {
    public static void main(String[] args) {
        int res = f(new Integer[]{3, 32, 321,1});
        System.out.println(res);
    }

    private static int f(Integer[] arr) {
        //自定义比较规则
        Arrays.sort(arr, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return Integer.parseInt(sb.toString());
    }
}
