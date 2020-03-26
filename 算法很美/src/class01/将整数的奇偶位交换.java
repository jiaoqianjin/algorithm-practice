package class01;

/**
 * @Auther:焦前进
 * @Data:2020/3/4
 * @Description:
 * 分析 先与 1010 1010 ....做 与运算    -①
 *     再与  0101 0101 ....做 与运算    -②
 *     得到的结果 ① 向右移一位 ② 向左移一位
 *     得出的结果 做异或运算
 *     即得到交换后的结果
 */
public class 将整数的奇偶位交换 {
    public static void main(String[] args) {
        int a = 6;
        int b = 9;
        int c = change(a);
        System.out.println(b==c);

    }

    private static int change(int i){
        //先与 1010 1010 1010 1010 .... 与运算取出偶数位
        int ou = i&0xaaaaaaaa;
        //再与 0101 0101 0101 0101 .... 与运算取出奇数位
        int ji = i&0x55555555;
        return (ou>>1)^(ji<<1);
    }
}
