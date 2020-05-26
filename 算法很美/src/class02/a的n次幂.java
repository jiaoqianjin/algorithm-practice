package class02;

/**
 * @Auther:焦前进
 * @Data:2020/3/17
 * @Description:
 */
public class a的n次幂 {
    static int pow0(int a, int n){
        int res = 1;
        for (int i = 0;i < n;i++){
            res = res * a;
        }
        return res;
    }

    //优化
    static int pow1(int a ,int n){
        if(n==0) return 1;
        int res = a;
        int es = 1;
        while ((es<<1) <= n){
            res = res * res;
            es <<=1;
        }
        return res*pow1(a,n-es);
    }
    /**
     * 巧算
     * m=1010
     */
    public static long pow3(long n, long m) {
        if (n == 0) return 1;
        long pingFangShu = n; //n 的 1 次方
        long result = 1;
        while (m != 0) {
            //遇1累乘现在的幂
            if ((m & 1) == 1)
                result *= pingFangShu;
            //每移位一次，幂累乘方一次
            pingFangShu = pingFangShu * pingFangShu;
            //右移一位
            m >>= 1;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(pow0(2,8));
        System.out.println(pow1(2,8));
        System.out.println(pow3(2,8));
    }
}
