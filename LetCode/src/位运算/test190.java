package 位运算;

/**
 * @Auther:焦前进
 * @Data:2020/3/6
 * @Description:颠倒给定的 32 位无符号整数的二进制位。
 */
public class test190 {
    /**
     * 思路一
     * 将 int  转化为  string
     * 将 string 翻转
     * 将翻转后的string 转化为 int 返回
     */


    /**
     * 思路二  位运算 i = 32
     *  使用变量  M 储存翻转后的数
     *  取出 N 的最低位，右移，去掉最低位
     *  M 左移，加N 的最低位,
     */
    public int reverseBits(int n){
        int m = 0;
        int i = 32;
        while (i > 0){
            m <<= 1; //先左移一位腾出位置
            m += n & 1; //加上n 的最后一位
            n >>= 1;    //n 右移一位将最后一位去掉
            i --;
        }
        return m;
    }

    public static void main(String[] args) {
        test190 t = new test190();
        System.out.println(t.reverseBits(   3));
    }
}
