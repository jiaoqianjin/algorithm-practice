package class01;

/**
 * @Auther:焦前进
 * @Data:2020/3/2
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        int num = 86;
        System.out.println((num & 1) == 1 ? "奇数" : "偶数");

        System.out.println("====判断第几位是几====");
        //? 对比的时候都要移动到最后一位吗？
        System.out.println(num + "第五位上的二进制数是" + (((num & (1 << 4)) >> 4) == 0 ? "0" : "1"));
        System.out.println(num + "第五位上的二进制数是" + ((((num >> 4) & 1) == 0) ? "0" : "1"));

        System.out.println("====数值交换====");
        int num1 = 10;
        int num2 = 20;

        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;

        System.out.println("num1 =" + num1 + "num2 =" + num2);

        System.out.println("====求绝对值====");

        int num3 = -20;
        System.out.println(num3 + "的绝对值是" + ((num3 ^ (num3 >> 31)) + (num3 >>> 31)));
    }
}
