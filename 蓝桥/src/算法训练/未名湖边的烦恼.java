package 算法训练;

import java.util.Scanner;

/**
 * Description：
 *每年冬天，北大未名湖上都是滑冰的好地方。北大体育组准备了许多冰鞋，可是人太多了，每天下午收工后，常常一双冰鞋都不剩。
 * 　　每天早上，租鞋窗口都会排起长龙，假设有还鞋的m个，有需要租鞋的n个。现在的问题是，这些人有多少种排法，
 * 可以避免出现体育组没有冰鞋可租的尴尬场面。（两个同样需求的人（比如都是租鞋或都是还鞋）交换位置是同一种排法）
 * @author jiaoqianjin
 * Date: 2020/5/29 16:39
 **/

public class 未名湖边的烦恼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int res = sort(m,n);
        System.out.println(res);
    }

    private static int sort(int m, int n) {
        if(m < n) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return sort(m - 1,n) + sort(m,n - 1);
    }
}
