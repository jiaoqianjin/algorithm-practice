package class06;
import sun.security.util.Length;

import static java.lang.StrictMath.log;
/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/4/13 15:57
 **/

/*
 * 自然数n之内的素数个数n/ln(n)
 * */
public class 第十万零二个素数 {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        //nlognlogn
        m1(100002);
        System.out.println("耗时：" + (System.currentTimeMillis() - now) + "ms");

        now = System.currentTimeMillis();
        int cnt = 0;
        long x = 2;
        while (cnt < 100002) {
            if (素数测试.isPrime(x))
                cnt++;
            x++;
        }
        System.out.println(x - 1);
        System.out.println("耗时：" + (System.currentTimeMillis() - now) + "ms");
    }

    /**
     * 求第N个素数
     * @param N
     */
    private static void m1(int N) {
        /**
         * N 是第N 个素数
         * 已知在整数 X 内大概有 X/log(X)个素数
         * 逆推：要求第N个素数，整数的范围应该是 N * log(n) = n
         */
        int length = 2;
        if(length/log(length) < N){
            length ++; //如果查找的范围小于N,那么增大范围
        }
        /**
         * 开辟一个数组，下标是自然数，值为标记,-1 为非素数
         * 将非素数标记出来
         */
        int[] arr = new int[length];
        int x = 2;
        while (x < length){
            //如果该数被标记过了，继续下一个
            if(arr[x] != 0) {
                x ++;
                continue;
            }
            int k = 2;
            //对于每个x,我们从2倍开始，对x 的 k 倍，全部标记为 -1
            while (x * k < length){
                arr[x * k] = -1;
                k++;
            }
            x ++;
        }
        int sum = 0;
        //遍历数组，值为0 的下标都为素数
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == 0){
                sum++;//
            }
            if(sum == N) { //第多少个素数
                System.out.println(i);
                return;
            }
        }
    }
}