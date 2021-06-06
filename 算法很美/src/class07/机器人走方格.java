package class07;

/**
 * Description：
 * 有一个x * y的网格，一个机器人只能走格点且只能向右或者向下走，要从左上角走到右下角
 * 请设计一个算法，计算机器人有多少种走法
 * 给定两个正整数int x，int y,请返回机器人的走法数目。保证x + y 小于等于12
 *
 * @author jiaoqianjin
 * Date: 2020/10/8 21:00
 **/

public class 机器人走方格 {
    /**
     * 递归
     *
     * @param x
     * @param y
     */
    public static int solve1(int x, int y) {
        if (x == 1 || y == 1) {
            return 1;
        }
        return solve1(x, y - 1) + solve1(x - 1, y);
    }

    /**
     * 迭代
     *
     * @param m
     * @param n
     * @return
     */
    public static int solve2(int m, int n) {
        int[][] arr = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            arr[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            arr[1][i] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[m][n];
    }

    public static void main(String[] args) {
        System.out.println(solve1(6, 6));
        System.out.println(solve2(6, 6));
    }
}
