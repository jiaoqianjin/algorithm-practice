package class01;

/**
 * @Auther:焦前进
 * @Data:2020/3/2
 * @Description:
 * 一个数组中除了某一个数字之外，其他的数字都出现了两次，请写出程序找出这个只出现一次的数字
 */
public class 找出落单的那个数 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,3,3,4,5,5,6,6,7,7};
        int x1 = 0;
        for (int i = 0; i < arr.length;i++){
            //x^x =0  x^0=x
            x1 = x1^arr[i];
        }
        System.out.println(x1);
        System.out.println(2^6);
    }
}
