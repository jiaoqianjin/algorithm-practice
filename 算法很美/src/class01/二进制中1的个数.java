package class01;

import java.util.Scanner;

/**
 * @Auther:焦前进
 * @Data:2020/3/2
 * @Description:
 */
public class 二进制中1的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Integer.toString(n,2));
        int count = 0;
        //将1 移动，比对每一位
        for (int i = 0;i < 32;i++){
            if ((n&(1<<i)) == (1<<i)){
                count++;
            }
        }
        System.out.println(count);
        System.out.println("====方法二====");
        // 移动数字，每一位与1 比较
        int count1 = 0;
        for (int i = 0;i < 32;i++){
            if (((n>>>i)&1)==1){
                count1++;
            }
        }
        System.out.println(count1);
        System.out.println("====方法三====");
        //复原count
        count = 0;
        //n-1再与自己做与运算 会抵消掉最后一位1
        while (n != 0){
            n=(n - 1 ) & n;
            count++;
        }
        System.out.println(count);
    }
}
