package class03.算法案例;

import class03.util;

import java.util.Arrays;

/**
 * @Auther:焦前进
 * @Data:2020/3/23
 * @Description:
 */
public class 扩充数组的方式 {
    /**
     * 方法一：使用for循环
     */
    public static int[] enlarge1(){
        int[] a = {1,2,3,4,5};
        int[] b = new int[10];
        // 将数组 a 的元素赋给 b
        for(int i = 0; i < a.length; i++){
            b[i] = a[i];
        }
        return b; //1 2 3 4 5 0 0 0 0 0
    }
    /**
     * 方法二：使用System.arraycopy
     */
    public static int[] enlarge2(){
        int[] a = {1,2,3,4,5};
        int[] b = new int[10];
        System.arraycopy(a,0,b,0,a.length);
        return b; //1 2 3 4 5 0 0 0 0 0
    }
    /**
     * 方法三：使用Arrays.copyOf
     */
    public static int[] enlarge3(){
        int[] a = {1,2,3,4,5};
        int[] b = Arrays.copyOf(a,10);
        return b; //1 2 3 4 5 0 0 0 0 0
    }
    public static void main(String[] args) {
        util.printArray(enlarge1());
        util.printArray(enlarge2());
        util.printArray(enlarge3());
    }
}
