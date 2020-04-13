package class06;

/**
 * @Author 焦前进
 * @Date: 2020/4/9 16:20
 * @Description:
 * 欧几里得算法，即辗转相除发
 **/
public class 欧几里得算法 {
    public static int gcd(int m, int n){
        return n == 0 ? m : gcd(n,m%n);
    }

    public static void main(String[] args) {
        System.out.println(gcd(4,56));
    }
}
