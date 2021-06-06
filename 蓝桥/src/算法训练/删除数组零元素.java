package 算法训练;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Description：
 *
 * 从键盘读入n个整数放入数组中，编写函数CompactIntegers，删除数组中所有值为0的元素，其后元素向数组首端移动。
 * 注意，CompactIntegers函数需要接受数组及其元素个数作为参数，函数返回值应为删除操作执行后数组的新元素个数。
 * 输出删除后数组中元素的个数并依次输出数组元素。
 *
 * @author jiaoqianjin
 * Date: 2020/6/5 15:03
 **/

public class 删除数组零元素 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arrayList.add(arr[i]);
            }
        }
        System.out.println(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
    }
}
