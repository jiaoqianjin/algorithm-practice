package class03.算法案例;

import util.Util;

import java.util.Scanner;

/**
 * @Author 焦前进
 * @Date: 2020/3/30 15:27
 * @Description:
 **/
public class 所有员工的年龄排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入公司内员工的人数：");
        int n = sc.nextInt();//公司内员工总数
        System.out.println("请输入每个员工的年龄：");
        int[] ages = new int[n];
        for (int i = 0;i < n;i++){
            ages[i] = sc.nextInt();
        }
        sort(ages);
        print(ages);
    }
    /**
     * 利用计数排序方法进行排序
     * @param ages
     * @return
     */
    public static int[] sort(int[] ages){
        int max = Util.maxOf(ages);
        int min = Util.minOf(ages);
        int[] helper = new int[max - min + 1];
        //将目标数组的元素，用辅助数组的下标表示，
        for(int e : ages){
            helper[e - min]++;
        }
        int current = 0;
        //将辅助数组表示的元素，回填到目标数组中
        for(int i = 0;i < helper.length;i++){
            while (helper[i] > 0){
                ages[current++] = i + min;
                helper[i]--;
            }
        }
        return ages;
    }
    public static void print(int[] args){
        for(int i = 0;i < args.length;i++){
            System.out.print(args[i] + " ");
        }
    }
}
