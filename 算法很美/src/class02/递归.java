package class02;

import sun.print.SunMinMaxPage;

import javax.sound.midi.Soundbank;

/**
 * @Auther:焦前进
 * @Data:2020/3/7
 * @Description:
 */
public class 递归 {
    /**
     * f1(n）==> 求 n 的阶乘
     * 找重复  n * （n -1)的阶乘，（n - 1)的阶乘，是对原问题的重复（规模更小）--子问题
     * 找变化，变化的量应该作为参数
     * 找边界 ：出口
     * @param n
     * @return
     */
    static int f1(int n){
        if(n == 1){
            return 1;
        }
        return n * f1(n - 1);
    }
    /**
     * 打印 i - j
     * 找重复
     * 找变化，变化的量应该作为参数
     * 找边界 ：出口
     * @param i,j
     * @return
     */
    static void f2(int i,int j){
        if (i == j){
            System.out.println();
            return;
        }
        System.out.print(i);
        f2(i + 1,j);
    }

    /**
     * 对 arr 所有值求和
     * 找重复
     * 找变化，变化的量应该作为参数
     * 找边界 ：出口
     * @param arr
     * @return
     */
    static int f3(int[] arr,int begin){
        if(begin == arr.length - 1){
            return arr[begin];
        }
        return arr[begin] + f3(arr,begin + 1);

    }
    /**
     * 翻转字符串
     * 找重复 ，d + abc 翻转，c + ab 翻转，b + a的翻转，加起来 dcba
     * 找变化，变化的量应该作为参数
     * 找边界 ：出口
     * @param s,end
     * @return
     */
    static String reverse(String s,int end){
        if (end == 0){
            return ""+s.charAt(0);
        }
        return s.charAt(end) + reverse(s,end-1);
    }

    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    static int fib(int n){
        if (n == 1 || n == 2){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
    /*
    辗转相除求最大公因数
     */
    static int gcd(int m,int n){
        if (n==0){
            return m;
        }
        return gcd(n,m%n);
    }

    /**
     * 递归插入排序
     * 对数组0~倒数第一个排序等价于:
     * 对数组的0~倒数第二个元素，这部分排序
     * 然后把是后一个元素插入到这个有序的部分中
     * @param arr
     * @param k
     */
    static void insertSort(int[] arr, int k) {
        if (k == 0) {
            return;
        }
        //对前k-1个元素排序
        insertSort(arr, k - 1);
        //把位置k的元素插入到前面的部分
        int x = arr[k];
        int index = k - 1;
        while (index > -1 && x < arr[index]) {
            arr[index + 1] = arr[index];
            index--;
        }
    }
    public static void main(String[] args) {
        System.out.println(f1(4));
        f2(8,12);
        System.out.println(f3(new int[]{1,2,3,4},0));
        System.out.println(reverse("女美是薇紫何",5));
        System.out.println(fib(5));
        System.out.println(gcd(15,12));

        insertSort(new int[]{1,2,5,8},3);
    }
}
