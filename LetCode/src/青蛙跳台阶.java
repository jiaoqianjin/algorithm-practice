/**
 * @Auther:焦前进
 * @Data:2020/3/24
 * @Description:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 */
public class 青蛙跳台阶 {
    public static int numWays(int n) {
        if(n==0) return 1;
        if(n==1) return 1;
        return numWays(n-1) + numWays(n-2);
    }

    public static void main(String[] args) {
        System.out.println(numWays(2));
    }
}
