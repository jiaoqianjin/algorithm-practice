package 位运算;

import java.awt.*;

/**
 * @Auther:焦前进
 * @Data:2020/3/6
 * @Description:
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class text231 {
    /**
     * 思路
     * 转化为二进制，判断是不是只有 一个 1
     */
    public boolean isPowerOfTwo(int n) {
        System.out.println(Integer.toString(n, 2));
        int count = 0;
        //将 i 移动 ，比对每一位
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) == (1 << i)) {
                count++;
            }
        }
        if(count == 1){
            return true;
        }
        return false;
    }
    public boolean isPowerOfTwo2(int n) {
        System.out.println(Integer.toString(n, 2));
        if (((n - 1) & n) == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        text231 t = new text231();
        System.out.println(t.isPowerOfTwo(16));
        System.out.println(t.isPowerOfTwo2(16));
    }
}
